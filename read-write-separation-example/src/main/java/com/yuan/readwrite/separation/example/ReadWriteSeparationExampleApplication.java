package com.yuan.readwrite.separation.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hansiyuan
 */
@SpringBootApplication
@MapperScan(basePackages = "com.yuan.readwrite.separation.example.*")
public class ReadWriteSeparationExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadWriteSeparationExampleApplication.class, args);
    }

}
