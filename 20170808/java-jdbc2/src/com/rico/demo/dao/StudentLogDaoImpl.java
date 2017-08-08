package com.rico.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Rico on 2017/8/8.
 */
public class StudentLogDaoImpl implements StudentLogDao {

    @Override
    public void insertLog(String content, Connection connection) throws Exception {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO student_log(content) VALUES(?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,content);
            preparedStatement.executeUpdate();
        } finally {
            SqlManager.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void insertLog(String content, Long fk_student, Connection connection) throws Exception {

        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO student_log(content, fk_student) VALUES(?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,content);
            preparedStatement.setLong(2,fk_student);
            preparedStatement.executeUpdate();
        } finally {
            SqlManager.closePreparedStatement(preparedStatement);
        }
    }
}
