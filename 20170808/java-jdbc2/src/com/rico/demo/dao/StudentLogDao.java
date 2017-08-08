package com.rico.demo.dao;

import java.sql.Connection;

/**
 * Created by Rico on 2017/8/8.
 */
public interface StudentLogDao {

    public void insertLog(String content, Connection connection) throws  Exception;
    public void insertLog(String content, Long fk_student, Connection connection) throws Exception;
}
