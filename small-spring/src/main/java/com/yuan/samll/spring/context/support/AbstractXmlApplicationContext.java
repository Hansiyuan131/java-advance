package com.yuan.samll.spring.context.support;

import com.yuan.samll.spring.beans.factory.support.DefaultListableBeanFactory;
import com.yuan.samll.spring.beans.reader.support.XmlBeanDefinitionReader;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:38
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
