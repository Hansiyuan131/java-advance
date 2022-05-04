package com.yuan.rpcfx.api;

/**
 * @author hansiyuan
 * @date 2022年05月04日 23:33
 */
public interface Filter {

    boolean filter(RpcfxRequest request);

    // Filter next();

}
