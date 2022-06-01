package com.yuan.samll.spring.context.support;

import com.yuan.samll.spring.beans.BeansException;
import com.yuan.samll.spring.beans.factory.support.ConfigurableListableBeanFactory;
import com.yuan.samll.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:37
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}