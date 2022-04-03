package com.yuan;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hansiyuan
 * @date 2022年04月03日 15:47
 */
@Data
@ConfigurationProperties(prefix = "yuan.custom")
public class CustomProperties {

    /**
     * 作者姓名
     */
    private String authorName;
    /**
     * 作者链接
     */
    private String authorLink;
    /**
     * 是否开启
     */
    private Boolean enabled;
}
