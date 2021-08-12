package com.wang.lesson04;

import com.wang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTransaction {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            // 关闭数据库自动提交，自动会开启事务
            connection.setAutoCommit(false);
            String sql1 = "update account set `money`=money-100 where `name`='A'";
            st = connection.prepareStatement(sql1);
            st.executeUpdate();

            String sql2 = "update account set `money`=money+100 where `name`='B'";
            st = connection.prepareStatement(sql2);
            st.executeUpdate();
            // 业务完毕，提交业务
            connection.commit();
            System.out.println("成功");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();// 如果失败则回滚事务
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            JdbcUtils.release(null,st,connection);
        }
    }
}
