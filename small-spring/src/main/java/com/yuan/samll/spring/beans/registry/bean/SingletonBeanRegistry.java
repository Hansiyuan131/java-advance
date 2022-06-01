package com.yuan.samll.spring.beans.registry.bean;

/**
 * @author hansiyuan
 * @date 2022年06月01日 22:58
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
