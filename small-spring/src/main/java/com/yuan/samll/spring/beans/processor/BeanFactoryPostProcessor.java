package com.yuan.samll.spring.beans.processor;

import com.yuan.samll.spring.beans.BeansException;
import com.yuan.samll.spring.beans.factory.support.ConfigurableListableBeanFactory;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:40
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
