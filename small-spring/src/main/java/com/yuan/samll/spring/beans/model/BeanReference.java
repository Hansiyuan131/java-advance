package com.yuan.samll.spring.beans.model;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:13
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
