package com.yuan.rpcfx.api;

import lombok.Data;

/**
 * @author hansiyuan
 * @date 2022年05月04日 23:34
 */
@Data
public class RpcfxResponse {
    private Object result;
    private boolean status;
    private Exception exception;
}
