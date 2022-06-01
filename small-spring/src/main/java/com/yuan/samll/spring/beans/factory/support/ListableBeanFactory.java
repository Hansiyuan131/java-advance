package com.yuan.samll.spring.beans.factory.support;

import com.yuan.samll.spring.beans.BeansException;
import com.yuan.samll.spring.beans.factory.BeanFactory;

import java.util.Map;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:26
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();

}
