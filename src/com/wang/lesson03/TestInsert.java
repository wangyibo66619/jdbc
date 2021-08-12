package com.wang.lesson03;

import com.wang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class TestInsert {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement st = null;
        try {
            connection = JdbcUtils.getConnection();
            // 区别
            // 使用 ？ 占位符代替参数
            String sql = "insert into users(`id`,`name`,password,email,birthday) values(?,?,?,?,?)";
            st = connection.prepareStatement(sql);// 预编译SQL，先写sql，然后不执行
            // 手动跟参数赋值
            st.setInt(1,4);
            st.setString(2,"dagen");
            st.setString(3,"123456");
            st.setString(4,"2375847849@qq.com");
            // 注意点：sql.Date  数据库
            //        util.Date   java         new Date().getTime()获取时间戳
            st.setDate(5,new java.sql.Date(new Date().getTime()));

            // 执行
            int i = st.executeUpdate();
            if (i>0) {
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(null,st,connection);
        }
    }
}
