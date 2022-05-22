package com.yuan.cache.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 环境配置
 * @author: hansiyuan
 * @date: 2022/5/22 7:34 PM
 */
@Configuration
@Getter
public class EnvConfig {

    @Value("${env}")
    private String env;

    /**
     * 日常环境
     */
    public boolean isDaily() {
        return "daily".equals(this.env);
    }

    /**
     * 预发布/仿真环境
     */
    public boolean isPrepub() {
        return "prepub".equals(this.env);
    }

    /**
     * 是否生产
     */
    public boolean isProduct() {
        return "product".equals(this.env);
    }
}
