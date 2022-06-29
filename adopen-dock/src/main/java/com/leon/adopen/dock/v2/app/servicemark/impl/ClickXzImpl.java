package com.leon.adopen.dock.v2.app.servicemark.impl;

import com.leon.adopen.common.constants.app.AppCodeConst;
import com.leon.adopen.common.constants.app.AppStUrlConst;
import com.leon.adopen.common.constants.app.AppUrlConst;
import com.leon.adopen.common.constants.app.BindChannelConst;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.utils.AppPortUtil;
import com.leon.adopen.common.utils.LeonHttpUtil;
import com.leon.adopen.dock.v2.app.servicemark.ClickXzService;
import com.leon.adopen.dock.v2.app.skip.FluxSkipYzService;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import com.leon.adopen.domain.pojo.BaseInfo;
import com.leon.adopen.domain.redis.AdopenCacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 仙战
 *
 * @author leon
 * @date 2021-12-24 12:45
 */
@Service
@Slf4j
public class ClickXzImpl implements ClickXzService {
    @Resource
    private AdopenCacheUtil cacheUtil;
    @Resource
    private AppPortUtil appPortUtil;
    @Resource
    private FluxSkipYzService skipYzService;

    private static final BaseInfo INFO_XZ_A1 = new BaseInfo();
    private static final BaseInfo INFO_XZ_A2 = new BaseInfo();

    @Override
    @Async
    public void click(String appid, String idfa, String ip, String channel, String callback) throws Exception {
        //app:xzA1  channel:1601
        if (appid.equals(AppCodeConst.XZ_A1)) {
            AppStUrlConst.URL_XZ_A1 = AppUrlConst.URL_TTBY
                    + "schan=140&os=1&campaign=138083&idfa=" + idfa + "&ip=" + ip
                    + "&callback=" + appPortUtil.back(channel, idfa, ip);
            this.run(AppCodeConst.XZ_A1, AppStUrlConst.URL_XZ_A1, channel);
            INFO_XZ_A1.setAppId(appid);
            INFO_XZ_A1.setChannel(channel);
            INFO_XZ_A1.setIdfa(idfa);
            INFO_XZ_A1.setIp(ip);
            INFO_XZ_A1.setCallback(callback);
            cacheUtil.saveInfo(INFO_XZ_A1);
            skipYzService.click(AppCodeConst.YZ_A1, idfa, ip, BindChannelConst.CHANNEL_1801);
        }
        //app:xzA2  channel:1602
        if (appid.equals(AppCodeConst.XZ_A2)) {
            AppStUrlConst.URL_XZ_A2 = AppUrlConst.URL_TTBY
                    + "schan=140&os=1&campaign=138084&idfa=" + idfa + "&ip=" + ip
                    + "&callback=" + appPortUtil.back(channel, idfa, ip);
            this.run(AppCodeConst.XZ_A2, AppStUrlConst.URL_XZ_A2, channel);
            INFO_XZ_A2.setAppId(appid);
            INFO_XZ_A2.setChannel(channel);
            INFO_XZ_A2.setIdfa(idfa);
            INFO_XZ_A2.setIp(ip);
            INFO_XZ_A2.setCallback(callback);
            cacheUtil.saveInfo(INFO_XZ_A2);
            skipYzService.click(AppCodeConst.YZ_A2, idfa, ip, BindChannelConst.CHANNEL_1802);
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
        log.info("xz:{} -> request -> [{}], response -> [{}], channel -> [{}], click -> [{}]", appId, requestUrl, LeonHttpUtil.get(requestUrl, appId, channel), channel, cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY));
    }
}
