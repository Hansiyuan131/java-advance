package com.yuan.samll.spring.context;

import com.yuan.samll.spring.beans.BeansException;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:36
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

}
