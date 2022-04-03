package com.yuan.springboot.jdbc.example.dao;

import com.yuan.springboot.jdbc.example.model.User;

/**
 * @author hansiyuan
 * @date 2022年04月03日 21:36
 */
public interface UserDao {

    /**
     * 新增用户
     */
    public long addUser(User user);
}
