package com.leon.adopen.dock.v2.app.servicemark;

import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.utils.LeonHttpUtil;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import com.leon.adopen.domain.redis.AdopenCacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author leon
 * @date 2022-07-07 14:14
 */
@Slf4j
@Service
public class ClickRun {

    @Resource
    private AdopenCacheUtil cacheUtil;

    /**
     * 统一处理
     *
     * @param appId      产品ID
     * @param requestUrl 产品请求链接
     * @param channel    渠道号
     * @throws AdopenDbException HTTP 请求异常
     */
    @Async
    public void run(String appId, String requestUrl, String channel) throws AdopenDbException {
        log.info("click -> {} -> request -> [{}], response -> [{}], channel -> [{}], click -> [{}]", appId, requestUrl, LeonHttpUtil.get(requestUrl, appId, channel), channel, cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY));
    }
}
