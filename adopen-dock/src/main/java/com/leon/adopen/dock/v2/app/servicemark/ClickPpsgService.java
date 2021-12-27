package com.leon.adopen.dock.v2.app.servicemark;

import org.springframework.scheduling.annotation.Async;

/**
 * @author leon
 * @date 2021-12-27 14:59
 */
public interface ClickPpsgService {
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
