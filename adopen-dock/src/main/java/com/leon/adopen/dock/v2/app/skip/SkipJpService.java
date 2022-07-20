package com.leon.adopen.dock.v2.app.skip;

import com.leon.adopen.common.constants.app.*;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.utils.AppPortUtil;
import com.leon.adopen.common.utils.CheckAppUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 极品芝麻官
 *
 * @author leon
 * @date 2022-07-07 16:11
 */
@Service
public class SkipJpService {

    @Resource
    private AppPortUtil appPortUtil;
    @Resource
    private CheckAppUtils checkAppUtils;
    @Resource
    private SkipRun skipRun;


    public void click(String appid, String idfa, String ip, String channel) throws Exception {
        //app:jpA1  channel:2201
        if (appid.equals(AppCodeConst.JP_A1)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.JP_A1, AppClickConst.CLICK_2201, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_JP_A1 = AppUrlConst.URL_TTBY
                        + "schan=140&os=1&campaign=136241&idfa=" + idfa + "&ip=" + ip
                        + "&callback=" + appPortUtil.back(channel, idfa, ip);
                skipRun.run(AppCodeConst.JP_A1, AppStUrlConst.URL_JP_A1, channel);
            }
        }
        //app:jpA2  channel:2202
        if (appid.equals(AppCodeConst.JP_A2)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.JP_A2, AppClickConst.CLICK_2202, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_JP_A2 = AppUrlConst.URL_TTBY
                        + "schan=140&os=1&campaign=136234&idfa=" + idfa + "&ip=" + ip
                        + "&callback=" + appPortUtil.back(channel, idfa, ip);
                skipRun.run(AppCodeConst.JP_A2, AppStUrlConst.URL_JP_A2, channel);
            }
        }
    }
}
