package com.yuan.samll.spring.beans.instantiation;

import com.yuan.samll.spring.beans.model.BeanDefinition;
import com.yuan.samll.spring.beans.BeansException;

import java.lang.reflect.Constructor;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:06
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}

