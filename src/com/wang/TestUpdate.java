package com.wang.lesson02;

import com.wang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();// 获取数据库连接
            statement = connection.createStatement();//获取SQL执行对象
            String sql = "update users set `NAME`='haha' where `ID`='1'";
            int i = statement.executeUpdate(sql);
            if (i>0) {
                System.out.println("修改成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(resultSet,statement, connection);
        }
    }
}
