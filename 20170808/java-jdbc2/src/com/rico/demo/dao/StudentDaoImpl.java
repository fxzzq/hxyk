package com.rico.demo.dao;

import com.mysql.jdbc.Driver;
import com.rico.demo.entities.Department;
import com.rico.demo.entities.Employee;
import com.rico.demo.entities.Student;
import com.rico.demo.view.Department_Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rico on 2017/8/7.
 */
public class StudentDaoImpl implements  StudentDao {

    private static final String INSERT_SQL = "INSERT INTO student(name, age) VALUES(?, ?)";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM student WHERE id = ?";
    private static final String SELECTS_SQL = "SELECT * FROM student";
    private static final String UPDATE_SQL = "UPDATE student SET name = ?, age = ? WHERE id = ?";

    @Override
    public int insert(Student student) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            connection = SqlManager.getConnection();

//        System.out.println(connection);

//        String sql = "INSERT INTO student(name, age) VALUES('" + student.getName() + "', " + student.getAge() + " )";

            // 占位符号 只能搭配 PreparedStatement
            preparedStatement = connection.prepareStatement(INSERT_SQL);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            result = preparedStatement.executeUpdate();
        } finally {
            SqlManager.closePreparedStatement(preparedStatement);
            SqlManager.closeConnection(connection);
        }

        return result;
    }

    @Override
    public int insert(Student student, Connection connection) throws Exception {

        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(INSERT_SQL);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            result = preparedStatement.executeUpdate();
        } finally {
            SqlManager.closePreparedStatement(preparedStatement);

        }

        return result;
    }

    @Override
    public Long insertAndGetId(Student student, Connection connection) throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Long id = 0L;
        try {
            preparedStatement = connection.prepareStatement(INSERT_SQL,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } finally {
            SqlManager.closePreparedStatement(preparedStatement);

        }

        return id;
    }

    @Override
    public Student select(Long id) throws Exception {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;
        try {
            connection = SqlManager.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BY_ID_SQL);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // 按位
//                student = new Student(resultSet.getLong(1),
//                        resultSet.getString(2), resultSet.getInt(3));
                // 按名
                student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));

            }
        } finally {
            SqlManager.closeResultSet(resultSet);
            SqlManager.closePreparedStatement(preparedStatement);
            SqlManager.closeConnection(connection);
        }


        return student;
    }

    @Override
    public Student select(String name) throws Exception {
        Connection connection =  null;
        // 调用存储过程的API
        /*创建存储过程
        存储过程创建后就保留在数据库上，可以一直调用
        * CREATE PROCEDURE selectStudentByName(
	        IN _name VARCHAR(200)
           )
            BEGIN
	       SELECT * FROM  student	WHERE name=_name;
           END;
        *
        *
        * */
        CallableStatement callableStatement = null;
        String sql = "{call selectStudentByName(?)}";
        ResultSet rs = null;
        Student student = null;
        try {
            connection = SqlManager.getConnection();
            callableStatement = connection.prepareCall(sql);
            callableStatement.setString(1, name);
            boolean hasResult = callableStatement.execute();
            if (hasResult) {
                rs = callableStatement.getResultSet();
                while(rs.next()) {

                    // 1 tom  (2) 2  开发部

//                    Department department = new Department();
//                    department.setId(rs.getLong(3));
//                    department.setName(rs.getString(4));
//                    Employee employee = new Employee();
//                    employee.setId(rs.getLong(1));
//                    employee.setName(rs.getString(2));
//                    Department_Employee department_employee = new Department_Employee();
//                    department_employee.setDepartment(department);
//                    department_employee.setEmployee(employee);


                    System.out.println(rs.getLong(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getInt(3));
                    student = new Student(rs.getLong(1), rs.getString(2), rs.getInt(3));
                }
            }
        } finally {
            if(callableStatement != null) {
                callableStatement.close();
            }
            SqlManager.closeConnection(connection);
        }

        return student;
    }

    @Override
    public List<Student> selects() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = SqlManager.getConnection();
            preparedStatement = connection.prepareStatement(SELECTS_SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student(resultSet.getLong(1),
                        resultSet.getString(2), resultSet.getInt(3));
                students.add(student);
            }
        } finally {
            SqlManager.closeResultSet(resultSet);
            SqlManager.closePreparedStatement(preparedStatement);
            SqlManager.closeConnection(connection);
        }

        return students;
    }

    @Override
    public int update(Student student) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            connection = SqlManager.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setLong(3, student.getId());
            i = preparedStatement.executeUpdate();
        } finally {
            SqlManager.closePreparedStatement(preparedStatement);
            SqlManager.closeConnection(connection);
        }
        return i;
    }

    /**
     * 批量操作 -》 事物
     * 1） 一张表多条数据
     * 2）多张表数据
     * @param ids
     * @throws Exception
     */
    @Override
    public void deletes(Long[] ids) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM student WHERE id = ?";
        int[] idList = null;
//        String sql = "delete from student where id in(1,2,3)";

        try {
            connection = SqlManager.getConnection();
            // 设置事物是手动提交
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            for(Long id : ids) {
                preparedStatement.setLong(1, id);
                // 加入批量操作
                preparedStatement.addBatch();
            }
            // 批量执行
            // 返回值，影响的行数的，长度为批量删除了多少个
           idList =  preparedStatement.executeBatch();
            // 事物提交-成功
           connection.commit();

            for (int i : idList) {
                System.out.println(i);
            }
        } catch (Exception e) {
            // 数据回滚
           connection.rollback();
           // 手动抛出语句，是为了通知上层，这里操作失败
           throw new Exception(e);
        } finally {
            SqlManager.closePreparedStatement(preparedStatement);
            SqlManager.closeConnection(connection);
        }

    }
}
