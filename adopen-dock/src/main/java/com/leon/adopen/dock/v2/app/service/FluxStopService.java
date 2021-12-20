package com.leon.adopen.dock.v2.app.service;

/**
 * 产品停量-service
 *
 * @author leon
 * @date 2021-12-20 16:19
 */
public interface FluxStopService {
    /**
     * 根据产品编码停止产品
     *
     * @param appCode 产品编码
     */
    void checkToStop(String appCode);
}
