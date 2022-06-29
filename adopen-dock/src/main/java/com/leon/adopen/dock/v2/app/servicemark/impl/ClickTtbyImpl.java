package com.leon.adopen.dock.v2.app.servicemark.impl;

import com.leon.adopen.common.constants.app.AppCodeConst;
import com.leon.adopen.common.constants.app.AppStUrlConst;
import com.leon.adopen.common.constants.app.AppUrlConst;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.utils.AppPortUtil;
import com.leon.adopen.common.utils.LeonHttpUtil;
import com.leon.adopen.dock.v2.app.servicemark.ClickTtbyService;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import com.leon.adopen.domain.pojo.BaseInfo;
import com.leon.adopen.domain.redis.AdopenCacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 测试
 *
 * @author leon
 * @date 2021-12-24 12:45
 */
@Service
@Slf4j
public class ClickTtbyImpl implements ClickTtbyService {
    @Resource
    private AdopenCacheUtil cacheUtil;
    @Resource
    private AppPortUtil appPortUtil;

    private static final BaseInfo INFO_TTBY_A1 = new BaseInfo();
    private static final BaseInfo INFO_TTBY_A2 = new BaseInfo();

    @Override
    @Async
    public void click(String appid, String idfa, String ip, String channel, String callback) throws Exception {
        //app:ttbyA1  channel:1501
        if (appid.equals(AppCodeConst.TTBY_A1)) {
            AppStUrlConst.URL_TTBY_A1 = AppUrlConst.URL_TTBY
                    + "schan=140&os=1&campaign=137034&idfa=" + idfa + "&ip=" + ip
                    + "&callback=" + appPortUtil.back(channel, idfa, ip);
            this.run(AppCodeConst.TTBY_A1, AppStUrlConst.URL_TTBY_A1, channel);
            INFO_TTBY_A1.setAppId(appid);
            INFO_TTBY_A1.setChannel(channel);
            INFO_TTBY_A1.setIdfa(idfa);
            INFO_TTBY_A1.setIp(ip);
            INFO_TTBY_A1.setCallback(callback);
            cacheUtil.saveInfo(INFO_TTBY_A1);
        }
        //app:ttbyA2  channel:1502
        if (appid.equals(AppCodeConst.TTBY_A2)) {
            AppStUrlConst.URL_TTBY_A2 = AppUrlConst.URL_TTBY
                    + "schan=140&os=1&campaign=137035&idfa=" + idfa + "&ip=" + ip
                    + "&callback=" + appPortUtil.back(channel, idfa, ip);
            this.run(AppCodeConst.TTBY_A2, AppStUrlConst.URL_TTBY_A2, channel);
            INFO_TTBY_A2.setAppId(appid);
            INFO_TTBY_A2.setChannel(channel);
            INFO_TTBY_A2.setIdfa(idfa);
            INFO_TTBY_A2.setIp(ip);
            INFO_TTBY_A2.setCallback(callback);
            cacheUtil.saveInfo(INFO_TTBY_A2);
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
        log.info("dts:{} -> request -> [{}], response -> [{}], channel -> [{}], click -> [{}]", appId, requestUrl, LeonHttpUtil.get(requestUrl, appId, channel), channel, cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY));
    }
}
