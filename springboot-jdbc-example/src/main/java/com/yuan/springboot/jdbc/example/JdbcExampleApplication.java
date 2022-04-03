package com.yuan.springboot.jdbc.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author hansiyuan
 */
@SpringBootApplication
@EnableConfigurationProperties
public class JdbcExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcExampleApplication.class, args);
    }

}
