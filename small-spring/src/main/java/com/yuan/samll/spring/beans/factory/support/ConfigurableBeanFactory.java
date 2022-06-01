package com.yuan.samll.spring.beans.factory.support;

import com.yuan.samll.spring.beans.processor.BeanPostProcessor;
import com.yuan.samll.spring.beans.registry.bean.SingletonBeanRegistry;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:27
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
