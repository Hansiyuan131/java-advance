package com.yuan.springboot.jdbc.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author hansiyuan
 * @date 2022年04月03日 21:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String userName;
    private String password;
    private Date createTime;
}
