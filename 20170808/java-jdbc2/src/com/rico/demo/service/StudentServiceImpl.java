package com.rico.demo.service;

import com.rico.demo.dao.*;
import com.rico.demo.entities.Student;
import com.rico.demo.tools.ValidationTools;
import com.rico.demo.view.Department_Employee;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

/**
 * Created by Rico on 2017/8/7.
 */
public class StudentServiceImpl implements  StudentService {

    private StudentDao studentDao = new StudentDaoImpl();
    private StudentLogDao studentLogDao = new StudentLogDaoImpl();


    @Override
    public int newStudent(String name, String age) throws Exception {
        // 数据的校验
        if(ValidationTools.isNull(name) || ValidationTools.isNull(age)) {
            throw new ServiceException("名字|年龄不能为空。");
        }


        if(!ValidationTools.isInteger(age)) {
            throw new ServiceException("年龄只能输入正整数。");
        }

        int intAge = Integer.parseInt(age);

        Student student = new Student(name, intAge);

        return this.studentDao.insert(student);
    }

    @Override
    public Student getStudent(String id) throws Exception {
        /**
         * 业务判断，id 非空 正整数
         */

        Long longId = Long.parseLong(id);

        return this.studentDao.select(longId);
    }

    @Override
    public Student getStudentByName(String name) throws Exception {

//        Department_Employee department_employee = null;
//        department_employee.getDepartment().getId();
//        department_employee.getEmployee().getId();
//        department_employee.getDepartment().getName();

        return this.studentDao.select(name);
    }

    @Override
    public List<Student> getStudents() throws Exception {
        return this.studentDao.selects();
    }

    @Override
    public int modifyStudent(String newName, String newAge, Student student) throws Exception {

        /**
         * 业务判断
         */


        // 封值
        student.setName(newName);
        student.setAge(Integer.parseInt(newAge));

        return this.studentDao.update(student);
    }

    /**
     * 1,2,3
     * @param idList
     * @throws Exception
     */
    @Override
    public void removeStudents(String idList) throws Exception {
        // 验证数据有效性

        String[] ids  = idList.split(",");

        Long[] idArray = new Long[ids.length];

        for(int i = 0; i < ids.length; i++) {
            idArray[i] = Long.parseLong(ids[i]);
        }
        this.studentDao.deletes(idArray);

    }

    @Override
    public void newStudentAndLog(String name, String age) throws Exception {

        // 校验

        int intAge = Integer.parseInt(age);

        Student student = new Student(name, intAge);

        /**
         * 操作多表能够管到事物的根本是在一次链接上执行多个操作
         * 并要设置手动提交事物和回滚数据
         */
        Connection connection = null;
        try {
            connection = SqlManager.getConnection();
            connection.setAutoCommit(false);

            Long id = this.studentDao.insertAndGetId(student, connection);
            this.studentLogDao.insertLog("增加操作", id, connection);

//            UUID uuid = UUID.randomUUID();
//            System.out.println(uuid);

//            this.studentDao.insert(student, connection);
//            this.studentLogDao.insertLog("add增加操作", connection);

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw  new Exception(e);
        } finally {
            SqlManager.closeConnection(connection);
        }


    }
}
