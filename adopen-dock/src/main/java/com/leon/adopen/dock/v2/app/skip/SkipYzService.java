package com.leon.adopen.dock.v2.app.skip;

import com.leon.adopen.common.constants.app.*;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.utils.AppPortUtil;
import com.leon.adopen.common.utils.CheckAppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 勇者养成记
 *
 * @author leon
 * @date 2022-06-28 00:51
 */
@Service
@Slf4j
public class SkipYzService {
    @Resource
    private AppPortUtil appPortUtil;
    @Resource
    private CheckAppUtils checkAppUtils;
    @Resource
    private SkipRun skipRun;


    /**
     * 规则：
     * A1->A3->A4->A5->A6
     * A2->A7
     *
     * @param appid   产品id
     * @param idfa    idfa
     * @param ip      ip
     * @param channel 渠道号
     * @throws Exception 请求异常
     */
    public void click(String appid, String idfa, String ip, String channel) throws Exception {
        //app:yzA1  channel:1801
        if (appid.equals(AppCodeConst.YZ_A1)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.YZ_A1, AppClickConst.CLICK_1801, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_ZY_A1 = AppUrlConst.URL_YZ
                        + "ext_info=494195&idfa=" + idfa + "&ip=" + ip
                        + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.YZ_A1, AppStUrlConst.URL_ZY_A1, channel);
            } else {
                this.click(AppCodeConst.YZ_A2, idfa, ip, BindChannelConst.CHANNEL_1802);
            }
        }
        //app:yzA2  channel:1802
        if (appid.equals(AppCodeConst.YZ_A2)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.YZ_A2, AppClickConst.CLICK_1802, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_ZY_A2 = AppUrlConst.URL_YZ
                        + "ext_info=494196&idfa=" + idfa + "&ip=" + ip
                        + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.YZ_A2, AppStUrlConst.URL_ZY_A2, channel);
            } else {
                this.click(AppCodeConst.YZ_A3, idfa, ip, BindChannelConst.CHANNEL_1803);
            }
        }
        //app:yzA3  channel:1803
        if (appid.equals(AppCodeConst.YZ_A3)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.YZ_A3, AppClickConst.CLICK_1803, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_ZY_A3 = AppUrlConst.URL_YZ
                        + "ext_info=494197&idfa=" + idfa + "&ip=" + ip
                        + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.YZ_A3, AppStUrlConst.URL_ZY_A3, channel);
            } else {
                this.click(AppCodeConst.YZ_A4, idfa, ip, BindChannelConst.CHANNEL_1804);
            }
        }
        //app:yzA4  channel:1804
        if (appid.equals(AppCodeConst.YZ_A4)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.YZ_A4, AppClickConst.CLICK_1804, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_ZY_A4 = AppUrlConst.URL_YZ
                        + "ext_info=494198&idfa=" + idfa + "&ip=" + ip
                        + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.YZ_A4, AppStUrlConst.URL_ZY_A4, channel);
            } else {
                this.click(AppCodeConst.YZ_A5, idfa, ip, BindChannelConst.CHANNEL_1805);
            }
        }
        //app:yzA5  channel:1805
        if (appid.equals(AppCodeConst.YZ_A5)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.YZ_A5, AppClickConst.CLICK_1805, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_ZY_A5 = AppUrlConst.URL_YZ
                        + "ext_info=494199&idfa=" + idfa + "&ip=" + ip
                        + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.YZ_A5, AppStUrlConst.URL_ZY_A5, channel);
            }
        }
    }
}
