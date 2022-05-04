package com.yuan.readwrite.separation.example.mapper;

import com.yuan.readwrite.separation.example.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: 用户
 * @author: hansiyuan
 * @date: 2022/4/20 11:57 AM
 */
@Mapper
public interface UserMapper {
    List<User> select();

    Long insert(User user);
}
