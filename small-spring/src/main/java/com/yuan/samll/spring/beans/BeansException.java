package com.yuan.samll.spring.beans;

/**
 * @author hansiyuan
 * @date 2022年06月01日 22:57
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
