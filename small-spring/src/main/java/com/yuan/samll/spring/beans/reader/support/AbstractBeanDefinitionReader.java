package com.yuan.samll.spring.beans.reader.support;

import com.yuan.samll.spring.beans.reader.BeanDefinitionReader;
import com.yuan.samll.spring.beans.registry.definition.BeanDefinitionRegistry;
import com.yuan.samll.spring.core.io.resourceload.ResourceLoader;
import com.yuan.samll.spring.core.io.resourceload.support.DefaultResourceLoader;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:24
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
