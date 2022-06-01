package com.yuan.samll.spring.core.io.resourceload;

import com.yuan.samll.spring.core.io.resource.Resource;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:21
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}

