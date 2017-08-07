package com.rico.demo.dao;

import com.mysql.jdbc.Driver;
import com.rico.demo.entities.Student;

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
    private static final String  DELETE_SQL="DELETE  FROM student where id=?";
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

    @Override
    public int delete(Long id) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;

        try {
            connection = SqlManager.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_SQL);
            preparedStatement.setLong(1,id);
            result = preparedStatement.executeUpdate();

        } finally {
            SqlManager.closePreparedStatement(preparedStatement);
            SqlManager.closeConnection(connection);
        }
        return result;
    }
}
