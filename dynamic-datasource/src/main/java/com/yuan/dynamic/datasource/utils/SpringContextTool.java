package com.yuan.dynamic.datasource.utils;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: SpringContext工具类
 * @author: hansiyuan
 * @date: 2022/4/17 5:55 PM
 */
@Component
public class SpringContextTool implements ApplicationContextAware {

    @Getter
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextTool.applicationContext = applicationContext;
    }

    public static <T> T getBean(String beanName) {
        if(applicationContext.containsBean(beanName)){
            return (T) applicationContext.getBean(beanName);
        }else{
            return null;
        }
    }

    public static <T> T getBean(Class<?> clazz) throws BeansException {
        return (T)applicationContext.getBean(clazz);
    }


    public static <T> Map<String, T> getBeansOfType(Class<T> baseType){
        return applicationContext.getBeansOfType(baseType);
    }

    public static <T> T getBean(String beanName, Object... args) throws BeansException {
        if(applicationContext.containsBean(beanName)){
            return (T) applicationContext.getBean(beanName,args);
        }else{
            return null;
        }
    }

}
