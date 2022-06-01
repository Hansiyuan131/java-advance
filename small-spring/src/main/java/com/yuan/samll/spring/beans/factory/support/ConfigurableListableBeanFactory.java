package com.yuan.samll.spring.beans.factory.support;

import com.yuan.samll.spring.beans.BeansException;
import com.yuan.samll.spring.beans.model.BeanDefinition;
import com.yuan.samll.spring.beans.processor.BeanPostProcessor;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:26
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
