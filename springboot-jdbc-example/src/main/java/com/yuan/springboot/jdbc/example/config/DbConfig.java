package com.yuan.springboot.jdbc.example.config;

import lombok.Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author hansiyuan
 * @date 2022年04月03日 22:39
 */
@Component
@PropertySource("classpath:config/db.properties")
@Data
public class DbConfig {
    private String username;
    private String password;
    private String driver;
    private String url;

    public Connection getCon() throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }
}
