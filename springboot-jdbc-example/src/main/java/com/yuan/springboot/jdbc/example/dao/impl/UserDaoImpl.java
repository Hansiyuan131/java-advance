package com.yuan.springboot.jdbc.example.dao.impl;

import com.yuan.springboot.jdbc.example.config.DbConfig;
import com.yuan.springboot.jdbc.example.dao.UserDao;
import com.yuan.springboot.jdbc.example.model.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author hansiyuan
 * @date 2022年04月03日 21:40
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public long addUser(User user) {
        try {
            String sql = ("INSERT INTO user(user_name,password,create_time,upd_time) VALUES(?,?,NOW(),NOW())");
            DbConfig dbConfig = new DbConfig();
            Connection conn = dbConfig.getCon();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1L;
    }
}
