package com.yuan.samll.spring.core.io.resourceload.support;

import cn.hutool.core.lang.Assert;
import com.yuan.samll.spring.core.io.resource.Resource;
import com.yuan.samll.spring.core.io.resource.support.ClassPathResource;
import com.yuan.samll.spring.core.io.resource.support.FileSystemResource;
import com.yuan.samll.spring.core.io.resource.support.UrlResource;
import com.yuan.samll.spring.core.io.resourceload.ResourceLoader;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:21
 */
public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }

}
