package com.leon.adopen.dock.v2.app.servicemark.impl;

import com.leon.adopen.common.constants.app.AppClickConstants;
import com.leon.adopen.common.constants.app.AppCodeConstants;
import com.leon.adopen.common.constants.app.AppStUrlConstants;
import com.leon.adopen.common.constants.app.AppUrlConstants;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.utils.AppPortUtil;
import com.leon.adopen.common.utils.CheckAppUtils;
import com.leon.adopen.common.utils.LeonHttpUtil;
import com.leon.adopen.dock.v2.app.service.FluxStopService;
import com.leon.adopen.dock.v2.app.servicemark.ClickFddsService;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import com.leon.adopen.domain.redis.AdopenCacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author leon
 * @date 2021-12-27 15:53
 */
@Service
@Slf4j
public class ClickFddsImpl implements ClickFddsService {
    @Resource
    private AdopenCacheUtil cacheUtil;
    @Resource
    private AppPortUtil appPortUtil;
    @Resource
    private CheckAppUtils checkAppUtils;
    @Resource
    private FluxStopService fluxStopService;

    @Override
    public void click(String appid, String idfa, String ip, String channel, String callback) throws Exception {
        //app:樊登读书-A1   fddsA1  1301
        if (appid.equals(AppCodeConstants.FDDS_A1)) {
            if (checkAppUtils.checkAppBindIsOn(AppCodeConstants.FDDS_A1)) {
                if (!checkAppUtils.checkLimitFull(appid, AppClickConstants.CLICK_1301, InitDateConstants.DATE_TODAY)) {
                    AppStUrlConstants.URL_FDDS_A1 = AppUrlConstants.URL_FDDS
                            + "/7juEbaa?os=&ua=&clickid=&ry_adplan_id=&ry_adcreative_id=&noredirect=true&idfa=" + idfa + "&ip=" + ip
                            + "&callback=" + appPortUtil.back(channel, idfa, ip);
                    this.run(AppCodeConstants.FDDS_A1, AppStUrlConstants.URL_FDDS_A1, channel);
                } else {
                    fluxStopService.checkToStop(appid);
                }
            }
        }
        //app:樊登读书-A2   fddsA2  1302
        if (appid.equals(AppCodeConstants.FDDS_A2)) {
            if (checkAppUtils.checkAppBindIsOn(AppCodeConstants.FDDS_A2)) {
                if (!checkAppUtils.checkLimitFull(appid, AppClickConstants.CLICK_1302, InitDateConstants.DATE_TODAY)) {
                    AppStUrlConstants.URL_FDDS_A2 = AppUrlConstants.URL_FDDS
                            + "/RzEVbma?os=&ua=&clickid=&ry_adplan_id=&ry_adcreative_id=&noredirect=true&idfa=" + idfa + "&ip=" + ip
                            + "&callback=" + appPortUtil.back(channel, idfa, ip);
                    this.run(AppCodeConstants.FDDS_A2, AppStUrlConstants.URL_FDDS_A2, channel);
                } else {
                    fluxStopService.checkToStop(appid);
                }
            }
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
        Integer incr = Math.toIntExact(cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY));
        log.info("szx:{} -> request -> [{}], response -> [{}], channel -> [{}], click -> [{}]", appId, requestUrl, LeonHttpUtil.get(requestUrl, appId, channel), channel, incr);
        if (appId.equals(AppCodeConstants.FDDS_A1)) {
            AppClickConstants.CLICK_1301 = incr;
        }
        if (appId.equals(AppCodeConstants.FDDS_A2)) {
            AppClickConstants.CLICK_1302 = incr;
        }
    }
}
