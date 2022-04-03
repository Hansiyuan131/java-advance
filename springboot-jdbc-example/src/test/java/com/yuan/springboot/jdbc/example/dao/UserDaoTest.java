package com.yuan.springboot.jdbc.example.dao;

import com.yuan.springboot.jdbc.example.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hansiyuan
 * @date 2022年04月03日 22:50
 */
@SpringBootTest
class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    void addUser() {
        User user = User.builder()
                .userName("hhaksdnka")
                .password("asdijidn21394n").build();
        System.out.println(userDao.addUser(user));
    }
}