package com.yuan.dynamic.datasource.infrastructure.mapper.secondary;

import com.yuan.dynamic.datasource.infrastructure.po.TestInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author hansiyuan
 * @date 2022年04月17日 16:30
 */
@SpringBootTest
public class TestMapperTestInfo {

    @Resource
    private TestMapper testMapper;

    @Test
    public void insert() {
        System.out.println(testMapper);
        TestInfo testInfo = new TestInfo();
        testInfo.setUserName("111");
        testInfo.setPassword("222");
        System.out.println(testMapper.insert(testInfo));
    }

}