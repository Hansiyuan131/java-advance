package com.yuan.rpcfx.api;

import lombok.Data;

/**
 * @author hansiyuan
 * @date 2022年05月04日 23:33
 */
@Data
public class RpcfxRequest {
    private String serviceClass;
    private String method;
    private Object[] params;
}
