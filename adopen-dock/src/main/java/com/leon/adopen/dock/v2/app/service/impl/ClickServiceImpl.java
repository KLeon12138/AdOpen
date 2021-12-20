package com.leon.adopen.dock.v2.app.service.impl;

import com.leon.adopen.common.constants.app.AppCodeConstants;
import com.leon.adopen.common.constants.app.AppStUrlConstants;
import com.leon.adopen.common.constants.app.AppUrlConstants;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.utils.AppPortUtil;
import com.leon.adopen.common.utils.LeonHttpUtil;
import com.leon.adopen.dock.v2.app.service.ClickService;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import com.leon.adopen.domain.pojo.BaseInfo;
import com.leon.adopen.domain.redis.AdopenCacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author leon
 * @date 2021-11-29 16:53
 */
@Service
@Slf4j
public class ClickServiceImpl implements ClickService {
    @Resource
    private AdopenCacheUtil cacheUtil;
    @Resource
    private AppPortUtil appPortUtil;

    private static final BaseInfo INFO = new BaseInfo();

    @Override
    @Async
    public void click(String appid, String idfa, String ip, String channel, String callback) throws Exception {
        //app:乐读文学A1  channel:1001
        if (appid.equals(AppCodeConstants.YDWX_A1)) {
            AppStUrlConstants.URL_YDWX_A1 = AppUrlConstants.URL_YDWX
                    + "/1001/ck?loid=68-1290083041&idfa=" + idfa + "&ip=" + ip + "&sub1=&sub2=&sub3="
                    + "&callback=" + appPortUtil.back(channel, idfa, ip);
            this.run(AppCodeConstants.YDWX_A1, AppStUrlConstants.URL_YDWX_A1, channel);
            INFO.setAppId(appid);
            INFO.setChannel(channel);
            INFO.setIdfa(idfa);
            INFO.setIp(ip);
            INFO.setCallback(callback);
            cacheUtil.saveInfo(INFO);
        }
        //app:乐读文学A2  channel:1002
        if (appid.equals(AppCodeConstants.YDWX_A2)) {
            AppStUrlConstants.URL_YDWX_A2 = AppUrlConstants.URL_YDWX
                    + "/1002/ck?loid=68-1290083041&idfa=" + idfa + "&ip=" + ip + "&sub1=&sub2=&sub3="
                    + "&callback=" + appPortUtil.back(channel, idfa, ip);
            this.run(AppCodeConstants.YDWX_A2, AppStUrlConstants.URL_YDWX_A2, channel);
            INFO.setAppId(appid);
            INFO.setChannel(channel);
            INFO.setIdfa(idfa);
            INFO.setIp(ip);
            INFO.setCallback(callback);
            cacheUtil.saveInfo(INFO);
        }
    }

    /**
     * 统一处理
     *
     * @param appId      产品ID
     * @param requestUrl 产品请求链接
     * @param channel    渠道号
     * @throws AdopenDbException HTTP 请求异常
     */
    @Async
    void run(String appId, String requestUrl, String channel) throws AdopenDbException {
        log.info("{} -> request -> [{}], response -> [{}], channel -> [{}], click -> [{}]", appId, requestUrl, LeonHttpUtil.get(requestUrl, appId, channel), channel, cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY));
    }
}
