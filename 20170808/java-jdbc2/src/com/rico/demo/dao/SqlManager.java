package com.rico.demo.dao;

import java.sql.*;

/**
 * Created by Rico on 2017/8/7.
 */
public class SqlManager {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;

        /**
         * JDBC API
         * Connection
         * DriverManager
         * Statement
         * PreparedStatement
         */
        // 注册驱动 -》 这句代码已经被封装到 Driver类中的static块中
//        DriverManager.registerDriver(new Driver());

        // 反射里面，获得Driver类的类类型
        // 加载Driver，执行static 静态块的内容
        Class.forName("com.mysql.jdbc.Driver");
        // 链接不同的数据库有不同的写法
        // 链接不同的数据库需要该数据库提供不同的驱动jar包
        String url = "jdbc:mysql://127.0.0.1:3306/demo_jdbc";
        // sqlserver 2005 2008
        // 第三方链接微软数据库： JTDS
//		String url = "jdbc:jtds:sqlserver://localhost:1433;databaseName=gy";
        // Oracle
//		String url = "jdbc:oracle:thin:@localhost:1521:gy";
        String user = "root";
        String password = "123456";

        connection = DriverManager.getConnection(url, user, password);

        return connection;
    }


    public static void closePreparedStatement(PreparedStatement preparedStatement) {
        if(preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static  void closeConnection(Connection connection) {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public  static  void closeResultSet(ResultSet resultSet) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
