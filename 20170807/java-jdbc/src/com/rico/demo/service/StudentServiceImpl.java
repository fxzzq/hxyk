package com.rico.demo.service;

import com.rico.demo.dao.StudentDao;
import com.rico.demo.dao.StudentDaoImpl;
import com.rico.demo.entities.Student;
import com.rico.demo.tools.ValidationTools;

import java.util.List;

/**
 * Created by Rico on 2017/8/7.
 */
public class StudentServiceImpl implements  StudentService {

    private StudentDao studentDao = new StudentDaoImpl();


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

    @Override
    public int deleteStudent(String id) throws Exception {
        /**
         * 业务判断，id 非空 正整数
         */

        Long longId = Long.parseLong(id);

        return this.studentDao.delete(longId);
    }
}
