package com.yuan.rpcfx.api;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年05月04日 23:34
 */
public interface Router {

    List<String> route(List<String> urls);
}
