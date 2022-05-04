package com.yuan.rpcfx.api;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年05月04日 23:34
 */
public interface LoadBalancer {

    String select(List<String> urls);

}