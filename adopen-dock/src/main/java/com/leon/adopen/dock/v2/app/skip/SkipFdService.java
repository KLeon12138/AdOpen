package com.leon.adopen.dock.v2.app.skip;

import com.leon.adopen.common.constants.app.*;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.utils.AppPortUtil;
import com.leon.adopen.common.utils.CheckAppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 樊登读书
 *
 * @author leon
 * @date 2022-06-28 00:51
 */
@Service
@Slf4j
public class SkipFdService {
    @Resource
    private AppPortUtil appPortUtil;
    @Resource
    private CheckAppUtils checkAppUtils;
    @Resource
    private SkipRun skipRun;


    public void click(String appid, String idfa, String ip, String channel) throws Exception {
        //app:fdA1  channel:1901
        if (appid.equals(AppCodeConst.FD_A1)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.FD_A1, AppClickConst.CLICK_1901, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_FD_A1 = AppUrlConst.URL_FD
                        + "/6jUbAra?csite=&siteid=&ry_adgroup_id=&ry_adplan_id=&ry_adplan_name=&ry_adcreative_id=&ctype=&csite=&siteid=&vid=&aid=&ry_adcreative_name=&ry_adgroup_name=&accountid=&ua=&noredirect=true&idfa_MD5=&gxid=&lgxid=&ts=&os=&callback_param="
                        + "&idfa=" + idfa + "&ip=" + ip + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.FD_A1, AppStUrlConst.URL_FD_A1, channel);
            } else {
                this.click(AppCodeConst.FD_A2, idfa, ip, BindChannelConst.CHANNEL_1902);
            }
        }
        //app:fdA2  channel:1902
        if (appid.equals(AppCodeConst.FD_A2)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.FD_A2, AppClickConst.CLICK_1902, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_FD_A2 = AppUrlConst.URL_FD
                        + "/aAveIja?csite=&siteid=&ry_adgroup_id=&ry_adplan_id=&ry_adplan_name=&ry_adcreative_id=&ctype=&csite=&siteid=&vid=&aid=&ry_adcreative_name=&ry_adgroup_name=&accountid=&ua=&noredirect=true&idfa_MD5=&gxid=&lgxid=&ts=&os=&callback_param="
                        + "&idfa=" + idfa + "&ip=" + ip + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.FD_A2, AppStUrlConst.URL_FD_A2, channel);
            } else {
                this.click(AppCodeConst.FD_A3, idfa, ip, BindChannelConst.CHANNEL_1903);
            }
        }
        //app:fdA3  channel:1903
        if (appid.equals(AppCodeConst.FD_A3)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.FD_A3, AppClickConst.CLICK_1903, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_FD_A3 = AppUrlConst.URL_FD
                        + "/qaqmqaa?csite=&siteid=&ry_adgroup_id=&ry_adplan_id=&ry_adplan_name=&ry_adcreative_id=&ctype=&csite=&siteid=&vid=&aid=&ry_adcreative_name=&ry_adgroup_name=&accountid=&ua=&noredirect=true&idfa_MD5=&gxid=&lgxid=&ts=&os=&callback_param="
                        + "&idfa=" + idfa + "&ip=" + ip + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.FD_A3, AppStUrlConst.URL_FD_A3, channel);
            } else {
                this.click(AppCodeConst.FD_A4, idfa, ip, BindChannelConst.CHANNEL_1904);
            }
        }
        //app:fdA4  channel:1904
        if (appid.equals(AppCodeConst.FD_A4)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.FD_A4, AppClickConst.CLICK_1904, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_FD_A4 = AppUrlConst.URL_FD
                        + "/InIbUra?csite=&siteid=&ry_adgroup_id=&ry_adplan_id=&ry_adplan_name=&ry_adcreative_id=&ctype=&csite=&siteid=&vid=&aid=&ry_adcreative_name=&ry_adgroup_name=&accountid=&ua=&noredirect=true&idfa_MD5=&gxid=&lgxid=&ts=&os=&callback_param="
                        + "&idfa=" + idfa + "&ip=" + ip + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.FD_A4, AppStUrlConst.URL_FD_A4, channel);
            } else {
                this.click(AppCodeConst.FD_A5, idfa, ip, BindChannelConst.CHANNEL_1905);
            }
        }
        //app:fdA5  channel:1905
        if (appid.equals(AppCodeConst.FD_A5)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.FD_A5, AppClickConst.CLICK_1905, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_FD_A5 = AppUrlConst.URL_FD
                        + "/3IbYvma?csite=&siteid=&ry_adgroup_id=&ry_adplan_id=&ry_adplan_name=&ry_adcreative_id=&ctype=&csite=&siteid=&vid=&aid=&ry_adcreative_name=&ry_adgroup_name=&accountid=&ua=&noredirect=true&idfa_MD5=&gxid=&lgxid=&ts=&os=&callback_param="
                        + "&idfa=" + idfa + "&ip=" + ip + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.FD_A5, AppStUrlConst.URL_FD_A5, channel);
            }
        }
        //app:fdA6  channel:1906
        if (appid.equals(AppCodeConst.FD_A6)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.FD_A6, AppClickConst.CLICK_1906, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_FD_A6 = AppUrlConst.URL_FD
                        + "/yi2Yf2a?csite=&siteid=&ry_adgroup_id=&ry_adplan_id=&ry_adplan_name=&ry_adcreative_id=&ctype=&csite=&siteid=&vid=&aid=&ry_adcreative_name=&ry_adgroup_name=&accountid=&ua=&noredirect=true&idfa_MD5=&gxid=&lgxid=&ts=&os=&callback_param="
                        + "&idfa=" + idfa + "&ip=" + ip + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.FD_A6, AppStUrlConst.URL_FD_A6, channel);
            } else {
                this.click(AppCodeConst.FD_A7, idfa, ip, BindChannelConst.CHANNEL_1907);
            }
        }
        //app:fdA7  channel:1907
        if (appid.equals(AppCodeConst.FD_A7)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.FD_A7, AppClickConst.CLICK_1907, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_FD_A7 = AppUrlConst.URL_FD
                        + "/JzQzYza?csite=&siteid=&ry_adgroup_id=&ry_adplan_id=&ry_adplan_name=&ry_adcreative_id=&ctype=&csite=&siteid=&vid=&aid=&ry_adcreative_name=&ry_adgroup_name=&accountid=&ua=&noredirect=true&idfa_MD5=&gxid=&lgxid=&ts=&os=&callback_param="
                        + "&idfa=" + idfa + "&ip=" + ip + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.FD_A7, AppStUrlConst.URL_FD_A7, channel);
            }
        }
        //app:fdA8  channel:1908
        if (appid.equals(AppCodeConst.FD_A8)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.FD_A8, AppClickConst.CLICK_1908, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_FD_A8 = AppUrlConst.URL_FD
                        + "/qUZzaaa?csite=&siteid=&ry_adgroup_id=&ry_adplan_id=&ry_adplan_name=&ry_adcreative_id=&ctype=&csite=&siteid=&vid=&aid=&ry_adcreative_name=&ry_adgroup_name=&accountid=&ua=&noredirect=true&idfa_MD5=&gxid=&lgxid=&ts=&os=&callback_param="
                        + "&idfa=" + idfa + "&ip=" + ip + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.FD_A8, AppStUrlConst.URL_FD_A8, channel);
            }
        }
    }
}
