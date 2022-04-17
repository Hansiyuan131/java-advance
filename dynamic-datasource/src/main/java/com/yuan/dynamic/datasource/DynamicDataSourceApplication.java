package com.yuan.dynamic.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hansiyuan
 * @date 2022年04月17日 14:55
 */
@SpringBootApplication
@MapperScan(basePackages = "com.yuan.dynamic.datasource.*")
public class DynamicDataSourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicDataSourceApplication.class, args);
    }
}
