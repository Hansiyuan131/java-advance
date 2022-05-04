package com.yuan.rpcfx.api;

import lombok.Builder;
import lombok.Data;

/**
 * @author hansiyuan
 * @date 2022年05月04日 23:34
 */
@Data
@Builder
public class ServiceProviderDesc {

    private String host;
    private Integer port;
    private String serviceClass;

    // group
    // version
}
