package com.leon.adopen.dock.v2.app.skip;

import com.leon.adopen.common.constants.app.AppClickConst;
import com.leon.adopen.common.constants.app.AppCodeConst;
import com.leon.adopen.common.constants.app.AppStUrlConst;
import com.leon.adopen.common.constants.app.AppUrlConst;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.utils.AppPortUtil;
import com.leon.adopen.common.utils.CLickCacheUtils;
import com.leon.adopen.common.utils.CheckAppUtils;
import com.leon.adopen.common.utils.LeonHttpUtil;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author leon
 * @date 2022-06-28 00:51
 */
@Service
@Slf4j
public class FluxSkipYzService {
    @Resource
    private AppPortUtil appPortUtil;
    @Resource
    private CheckAppUtils checkAppUtils;
    @Resource
    private CLickCacheUtils cLickCacheUtils;


    public void click(String appid, String idfa, String ip, String channel) throws Exception {
        //app:yzA1  channel:1801
        if (appid.equals(AppCodeConst.YZ_A1)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.YZ_A1, AppClickConst.CLICK_1801, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_ZY_A1 = AppUrlConst.URL_YZ
                        + "ext_info=494195&idfa=" + idfa + "&ip=" + ip
                        + "&callback=" + appPortUtil.getBackToMe(channel, idfa, ip);
                this.run(AppCodeConst.YZ_A1, AppStUrlConst.URL_ZY_A1, channel);
            }
        }
        //app:yzA2  channel:1802
        if (appid.equals(AppCodeConst.YZ_A2)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.YZ_A2, AppClickConst.CLICK_1802, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_ZY_A2 = AppUrlConst.URL_YZ
                        + "ext_info=494196&idfa=" + idfa + "&ip=" + ip
                        + "&callback=" + appPortUtil.getBackToMe(channel, idfa, ip);
                this.run(AppCodeConst.YZ_A2, AppStUrlConst.URL_ZY_A2, channel);
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
        log.info("yz:{} -> request -> [{}], response -> [{}], channel -> [{}], click -> [{}]", appId, requestUrl, LeonHttpUtil.get(requestUrl, appId, channel), channel, cLickCacheUtils.saveClick(channel));
    }
}
