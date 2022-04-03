package com.yuan.springboot.jdbc.example;

import com.yuan.CustomProperties;
import com.yuan.Klass;
import com.yuan.springboot.jdbc.example.config.DbConfig;
import com.yuan.springboot.jdbc.example.config.SystemConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author hansiyuan
 * @date 2022年04月03日 15:59
 */
@SpringBootTest
public class CustomStarterTest {

    @Resource
    private CustomProperties customProperties;
    @Resource
    private Klass klass;
    @Resource
    private SystemConfig systemConfig;
    @Resource
    private DbConfig dbConfig;

    @Test
    public void test() {
        System.out.println(klass);
        System.out.println(customProperties);
        System.out.println(systemConfig);
        System.out.println(dbConfig);
    }
}
