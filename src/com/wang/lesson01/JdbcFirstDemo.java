package com.wang.lesson01;

import java.sql.*;

// 我的第一个JDBC程序
public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbcStudy?useUnicode=true&character=uft8&useSSL=false";
        String username = "root";
        String password = "123456";
        // 3.连接成功，数据库对象    Connection 代表数据库对象
        Connection connection = DriverManager.getConnection(url, username, password);
        // 4.执行SQL的对象
        Statement statement = connection.createStatement();
        // 5.执行SQL的对象去执行SQL
        String sql = "select * from users";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("pwd=" + resultSet.getObject("password"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birthday=" + resultSet.getObject("birthday"));
            System.out.println("=====================================");
        }
        // 6.释放连接
        statement.close();
        resultSet.close();
        connection.close();

    }
}
