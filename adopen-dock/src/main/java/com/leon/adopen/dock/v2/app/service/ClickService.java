package com.leon.adopen.dock.v2.app.service;

import org.springframework.scheduling.annotation.Async;

/**
 * @author leon
 * @date 2021-11-29 16:53
 */
public interface ClickService {
    /**
     * 点击上报
     *
     * @param appid    产品 ID
     * @param idfa     idfa
     * @param ip       ip
     * @param channel  渠道号
     * @param callback 回调地址
     * @throws Exception 空参校验
     */
    @Async
    void click(String appid, String idfa, String ip, String channel, String callback) throws Exception;
}
