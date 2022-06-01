package com.yuan.samll.spring.beans.factory;

import com.yuan.samll.spring.beans.BeansException;

/**
 * @author hansiyuan
 * @date 2022年06月01日 22:57
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
