package com.wang.lesson02;

import com.wang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();// 获取数据库连接
            statement = connection.createStatement();//获取SQL执行对象
            String sql = "select * from users";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("name=" + resultSet.getString("name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(resultSet,statement, connection);
        }
    }
}
