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
import com.leon.adopen.dock.v2.app.servicemark.ClickPpsgService;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import com.leon.adopen.domain.redis.AdopenCacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author leon
 * @date 2021-12-27 14:59
 */
@Service
@Slf4j
public class ClickPpsgImpl implements ClickPpsgService {
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
        //app:啪啪三国-A1   ppsgA1  1201
        if (appid.equals(AppCodeConstants.PPSG_A1)) {
            if (checkAppUtils.checkAppBindIsOn(AppCodeConstants.PPSG_A1)) {
                if (!checkAppUtils.checkLimitFull(appid, AppClickConstants.CLICK_1201, InitDateConstants.DATE_TODAY)) {
                    AppStUrlConstants.URL_PPSG_A1 = AppUrlConstants.URL_PPSG
                            + "/I3UjMba?idfa=" + idfa + "&ip=" + ip
                            + "&callback=" + appPortUtil.back(channel, idfa, ip);
                    this.run(AppCodeConstants.PPSG_A1, AppStUrlConstants.URL_PPSG_A1, channel);
                } else {
                    fluxStopService.checkToStop(appid);
                }
            }
        }
        //app:啪啪三国-A2   ppsgA2  1202
        if (appid.equals(AppCodeConstants.PPSG_A2)) {
            if (checkAppUtils.checkAppBindIsOn(AppCodeConstants.PPSG_A2)) {
                if (!checkAppUtils.checkLimitFull(appid, AppClickConstants.CLICK_1202, InitDateConstants.DATE_TODAY)) {
                    AppStUrlConstants.URL_PPSG_A2 = AppUrlConstants.URL_PPSG
                            + "/FZBRrea?idfa=" + idfa + "&ip=" + ip
                            + "&callback=" + appPortUtil.back(channel, idfa, ip);
                    this.run(AppCodeConstants.PPSG_A2, AppStUrlConstants.URL_PPSG_A2, channel);
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
        if (appId.equals(AppCodeConstants.PPSG_A1)) {
            AppClickConstants.CLICK_1201 = incr;
        }
        if (appId.equals(AppCodeConstants.PPSG_A2)) {
            AppClickConstants.CLICK_1202 = incr;
        }
    }
}
