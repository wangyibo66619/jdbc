package com.wang.lesson03;

import com.wang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class TestUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement st = null;
        try {
            connection = JdbcUtils.getConnection();
            // 区别
            // 使用 ？ 占位符代替参数
            String sql = "update users set `name`=? where `name`=?";
            st = connection.prepareStatement(sql);// 预编译SQL，先写sql，然后不执行
            // 手动跟参数赋值
            st.setString(1,"xiaogen");
            st.setString(2,"haha");

            // 执行
            int i = st.executeUpdate();
            if (i>0) {
                System.out.println("更新成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(null,st,connection);
        }
    }
}
