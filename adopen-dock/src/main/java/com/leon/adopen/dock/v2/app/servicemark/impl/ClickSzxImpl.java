package com.leon.adopen.dock.v2.app.servicemark.impl;

import com.leon.adopen.common.constants.app.AppCodeConstants;
import com.leon.adopen.common.constants.app.AppStUrlConstants;
import com.leon.adopen.common.constants.app.AppUrlConstants;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.utils.AppPortUtil;
import com.leon.adopen.common.utils.LeonHttpUtil;
import com.leon.adopen.dock.v2.app.servicemark.ClickPpsgService;
import com.leon.adopen.dock.v2.app.servicemark.ClickSzxService;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import com.leon.adopen.domain.pojo.BaseInfo;
import com.leon.adopen.domain.redis.AdopenCacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author leon
 * @date 2021-12-24 12:45
 */
@Service
@Slf4j
public class ClickSzxImpl implements ClickSzxService {
    @Resource
    private AdopenCacheUtil cacheUtil;
    @Resource
    private AppPortUtil appPortUtil;
    @Resource
    private ClickPpsgService ppsgService;

    private static final BaseInfo INFO_SZX_A1 = new BaseInfo();
    private static final BaseInfo INFO_SZX_A2 = new BaseInfo();
    private static final BaseInfo INFO_SZX_A3 = new BaseInfo();
    private static final BaseInfo INFO_SZX_A4 = new BaseInfo();

    @Override
    @Async
    public void click(String appid, String idfa, String ip, String channel, String callback) throws Exception {
        //app:神州行-A1  channel:1101
        if (appid.equals(AppCodeConstants.SZX_A1)) {
            AppStUrlConstants.URL_SXZ_A1 = AppUrlConstants.URL_SZX
                    + "aid=4714&gameId=3025&cid=szxpj_wap1_myt_001&os=ios&clickType=2&idfa=" + idfa + "&ip=" + ip
                    + "&activeCallBackUrl=" + appPortUtil.back(channel, idfa, ip);
            this.run(AppCodeConstants.SZX_A1, AppStUrlConstants.URL_SXZ_A1, channel);
            INFO_SZX_A1.setAppId(appid);
            INFO_SZX_A1.setChannel(channel);
            INFO_SZX_A1.setIdfa(idfa);
            INFO_SZX_A1.setIp(ip);
            INFO_SZX_A1.setCallback(callback);
            cacheUtil.saveInfo(INFO_SZX_A1);
        }
        //app:神州行-A2  channel:1102
        if (appid.equals(AppCodeConstants.SZX_A2)) {
            AppStUrlConstants.URL_SXZ_A2 = AppUrlConstants.URL_SZX
                    + "aid=4714&gameId=3025&cid=szxpj_wap1_myt_002&os=ios&clickType=2&idfa=" + idfa + "&ip=" + ip
                    + "&activeCallBackUrl=" + appPortUtil.back(channel, idfa, ip);
            this.run(AppCodeConstants.SZX_A2, AppStUrlConstants.URL_SXZ_A2, channel);
            INFO_SZX_A2.setAppId(appid);
            INFO_SZX_A2.setChannel(channel);
            INFO_SZX_A2.setIdfa(idfa);
            INFO_SZX_A2.setIp(ip);
            INFO_SZX_A2.setCallback(callback);
            cacheUtil.saveInfo(INFO_SZX_A2);
        }
        //app:神州行-A3  channel:1103
        if (appid.equals(AppCodeConstants.SZX_A3)) {
            AppStUrlConstants.URL_SXZ_A3 = AppUrlConstants.URL_SZX
                    + "aid=4714&gameId=3025&cid=szxpj_wap1_myt_003&os=ios&clickType=2&idfa=" + idfa + "&ip=" + ip
                    + "&activeCallBackUrl=" + appPortUtil.back(channel, idfa, ip);
            this.run(AppCodeConstants.SZX_A3, AppStUrlConstants.URL_SXZ_A3, channel);
            INFO_SZX_A3.setAppId(appid);
            INFO_SZX_A3.setChannel(channel);
            INFO_SZX_A3.setIdfa(idfa);
            INFO_SZX_A3.setIp(ip);
            INFO_SZX_A3.setCallback(callback);
            cacheUtil.saveInfo(INFO_SZX_A3);
            ppsgService.click(AppCodeConstants.PPSG_A1, idfa, ip, "1201", "");
        }
        //app:神州行-A4  channel:1104
        if (appid.equals(AppCodeConstants.SZX_A4)) {
            AppStUrlConstants.URL_SXZ_A4 = AppUrlConstants.URL_SZX
                    + "aid=4714&gameId=3025&cid=szxpj_wap1_myt_004&os=ios&clickType=2&idfa=" + idfa + "&ip=" + ip
                    + "&activeCallBackUrl=" + appPortUtil.back(channel, idfa, ip);
            this.run(AppCodeConstants.SZX_A4, AppStUrlConstants.URL_SXZ_A4, channel);
            INFO_SZX_A4.setAppId(appid);
            INFO_SZX_A4.setChannel(channel);
            INFO_SZX_A4.setIdfa(idfa);
            INFO_SZX_A4.setIp(ip);
            INFO_SZX_A4.setCallback(callback);
            cacheUtil.saveInfo(INFO_SZX_A4);
            ppsgService.click(AppCodeConstants.PPSG_A2, idfa, ip, "1202", "");
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
        log.info("szx:{} -> request -> [{}], response -> [{}], channel -> [{}], click -> [{}]", appId, requestUrl, LeonHttpUtil.get(requestUrl, appId, channel), channel, cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY));
    }
}
