package com.rico.demo.dao;

import com.rico.demo.entities.Student;

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

    public Student select(Long id) throws Exception;

    public List<Student> selects() throws Exception;

    public int update(Student student) throws Exception;

    public int delete(Long id) throws  Exception;

}
