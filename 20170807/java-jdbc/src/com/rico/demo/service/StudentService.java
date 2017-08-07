package com.rico.demo.service;

import com.rico.demo.entities.Student;

import java.util.List;

/**
 * Created by Rico on 2017/8/7.
 */
public interface StudentService {

    public int newStudent(String name, String age) throws Exception;

    public Student getStudent(String id) throws Exception;
//    public Student getStudent(String name) throws Exception;

    public List<Student> getStudents() throws Exception;

    public int modifyStudent(String newName, String newAge, Student student) throws Exception;

    public int  deleteStudent(String id) throws Exception;



}
