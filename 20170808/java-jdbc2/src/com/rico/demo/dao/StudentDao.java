package com.rico.demo.dao;

import com.rico.demo.entities.Student;

import java.sql.Connection;
import java.util.List;

/**
 *
 * CRUD
 * Create Read Update Delete
 *
 * New(Add) Modify Remove Query(Get)
 *
 * Insert Update Delete Select
 *
 *
 * Created by Rico on 2017/8/7.
 */
public interface StudentDao {

    public int insert(Student student) throws Exception;
    public int insert(Student student, Connection connection) throws Exception;
    public Long insertAndGetId(Student student, Connection connection) throws Exception;


    public Student select(Long id) throws Exception;
    public Student select(String name) throws Exception;

    public List<Student> selects() throws Exception;

    public int update(Student student) throws Exception;

    public void deletes(Long[] ids) throws  Exception;

}
