package com.yuan.springboot.jdbc.example.dao;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @author hansiyuan
 * @date 2022年04月03日 22:14
 */
public class JDBCDemo {
    @Test
    public void test() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获取连接对象
        String url = "jdbc:mysql://127.0.0.1:3306/best-practices?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
        Connection conn = DriverManager.getConnection(url, "root", "mysql123456");
        // 3.获取执行SQL语句
        Statement stat = conn.createStatement();
        // 拼写SQL语句
        String sql = "select * from user";
        // 4.调用执行者对象方法,执行SQL语句获取结果集
        // 返回的是ResultSet接口的实现类对象,实现类在mysql驱动中
        ResultSet rs = stat.executeQuery(sql);

        // 4. 执行sql语句
        //通过执行者对象调用方法执行SQL语句,获取结果
        //int executeUpdate(String sql)  执行数据库中的SQL语句,仅限于insert,update,delete
        //返回值int,操作成功数据库的行数
        //int row = stat.executeUpdate("INSERT INTO user(user_name,password,create_time,upd_time) VALUES('hhh','1234567',NOW(),NOW())");
        //System.out.println(row);


        // 5.处理结果集
        // ResultSet接口的方法 boolean next() 有结果集true,没有结果集返回false
        System.out.println(rs);
        while (rs.next()) {
            // 获取每列的数据,使用的是ResultSet接口的方法getXXX
            int id = rs.getInt("id");// 相当于rs.getInt(1);这个方法有弊端
            String userName = rs.getString("user_name");
            Date createTime = rs.getDate("create_time");
            System.out.println(id + "\t" + userName + "\t" + createTime);
        }

        // 6.关闭资源
        rs.close();
        stat.close();
        conn.close();
    }
}
