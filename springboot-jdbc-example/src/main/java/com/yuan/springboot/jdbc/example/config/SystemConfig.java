package com.yuan.springboot.jdbc.example.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hansiyuan
 * @date 2022年04月03日 21:46
 */
@Component
@ConfigurationProperties(prefix = "yuan.system")
@Data
public class SystemConfig {
    private String projectName;
}
