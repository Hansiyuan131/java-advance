package com.yuan.samll.spring.beans.reader;

import com.yuan.samll.spring.beans.BeansException;
import com.yuan.samll.spring.beans.registry.definition.BeanDefinitionRegistry;
import com.yuan.samll.spring.core.io.resource.Resource;
import com.yuan.samll.spring.core.io.resourceload.ResourceLoader;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:22
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();


    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

}
