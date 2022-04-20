package com.yuan.readwrite.separation.example.mapper;

import com.yuan.readwrite.separation.example.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void select() {
        List<User> users = userMapper.select();
        System.out.println(users);
    }

    @Test
    void insert() {
        User user = new User();
        user.setName("hhhh");
        Long rows = userMapper.insert(user);
        System.out.println(user);
    }
}