package com.yuan.samll.spring.beans.model;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:12
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
