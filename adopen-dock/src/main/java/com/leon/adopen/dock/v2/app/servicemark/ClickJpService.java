package com.leon.adopen.dock.v2.app.servicemark;

import com.leon.adopen.common.constants.app.AppCodeConst;
import com.leon.adopen.common.constants.app.AppStUrlConst;
import com.leon.adopen.common.constants.app.AppUrlConst;
import com.leon.adopen.common.constants.app.BindChannelConst;
import com.leon.adopen.common.utils.AppPortUtil;
import com.leon.adopen.dock.v2.app.skip.SkipFdService;
import com.leon.adopen.dock.v2.app.skip.SkipYxfService;
import com.leon.adopen.dock.v2.app.skip.SkipYzService;
import com.leon.adopen.domain.pojo.BaseInfo;
import com.leon.adopen.domain.redis.AdopenCacheUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 极品芝麻官
 *
 * @author leon
 * @date 2022-07-08 15:57
 */
@Service
public class ClickJpService {
    @Resource
    private AppPortUtil appPortUtil;
    @Resource
    private ClickRun clickRun;
    @Resource
    private AdopenCacheUtil cacheUtil;
    @Resource
    private SkipYzService skipYzService;
    @Resource
    private SkipFdService skipFdService;
    @Resource
    private SkipYxfService skipYxfService;

    private static final BaseInfo INFO_JP_A3 = new BaseInfo();
    private static final BaseInfo INFO_JP_A4 = new BaseInfo();

    public void click(String appid, String idfa, String ip, String channel, String callback) throws Exception {
        //app:jpA3  channel:2203
        if (appid.equals(AppCodeConst.JP_A3)) {
            AppStUrlConst.URL_JP_A3 = AppUrlConst.URL_TTBY
                    + "schan=140&os=1&campaign=136241&idfa=" + idfa + "&ip=" + ip
                    + "&callback=" + appPortUtil.back(channel, idfa, ip);
            clickRun.run(AppCodeConst.JP_A3, AppStUrlConst.URL_JP_A3, channel);
            INFO_JP_A3.setChannel(channel);
            INFO_JP_A3.setIdfa(idfa);
            INFO_JP_A3.setIp(ip);
            INFO_JP_A3.setCallback(callback);
            cacheUtil.saveInfo(INFO_JP_A3);
            skipYxfService.click(AppCodeConst.YXF_A1, idfa, ip, BindChannelConst.CHANNEL_2101);
            skipYzService.click(AppCodeConst.YZ_A1, idfa, ip, BindChannelConst.CHANNEL_1801);
            skipFdService.click(AppCodeConst.FD_A1, idfa, ip, BindChannelConst.CHANNEL_1901);
        }
        //app:jpA4  channel:2204
        if (appid.equals(AppCodeConst.JP_A4)) {
            AppStUrlConst.URL_JP_A4 = AppUrlConst.URL_TTBY
                    + "schan=140&os=1&campaign=136234&idfa=" + idfa + "&ip=" + ip
                    + "&callback=" + appPortUtil.back(channel, idfa, ip);
            clickRun.run(AppCodeConst.JP_A4, AppStUrlConst.URL_JP_A4, channel);
            INFO_JP_A4.setChannel(channel);
            INFO_JP_A4.setIdfa(idfa);
            INFO_JP_A4.setIp(ip);
            INFO_JP_A4.setCallback(callback);
            cacheUtil.saveInfo(INFO_JP_A4);
            skipFdService.click(AppCodeConst.FD_A8, idfa, ip, BindChannelConst.CHANNEL_1908);
        }
    }
}
