package com.yuan;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 自定义starter
 *
 * @author hansiyuan
 * @date 2022年04月03日 15:44
 */
@Configuration
@ConditionalOnProperty(name = "yuan.custom.enabled", havingValue = "true")
@EnableConfigurationProperties(CustomProperties.class)
public class CustomAutoConfig {

    @Resource
    private CustomProperties customProperties;

    @Bean
    public Klass klass() {
        System.out.println("---------------------" + customProperties);
        return new Klass(customProperties);
    }
}
