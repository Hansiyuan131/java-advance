package com.yuan.samll.spring.beans.registry.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:01
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

}
