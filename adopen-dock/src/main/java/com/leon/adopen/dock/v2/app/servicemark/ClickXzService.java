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
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 仙战
 *
 * @author leon
 * @date 2022-07-07 14:00
 */
@Service
@Slf4j
public class ClickXzService {
    @Resource
    private AdopenCacheUtil cacheUtil;
    @Resource
    private AppPortUtil appPortUtil;
    @Resource
    private ClickRun clickRun;
    @Resource
    private SkipYzService skipYzService;
    @Resource
    private SkipFdService skipFdService;
    @Resource
    private SkipYxfService skipYxfService;

    private static final BaseInfo INFO_XZ_A1 = new BaseInfo();
    private static final BaseInfo INFO_XZ_A2 = new BaseInfo();
    private static final BaseInfo INFO_XZ_A4 = new BaseInfo();

    @Async
    public void click(String appid, String idfa, String ip, String channel, String callback) throws Exception {
        //app:xzA1  channel:1601
        if (appid.equals(AppCodeConst.XZ_A1)) {
            AppStUrlConst.URL_XZ_A1 = AppUrlConst.URL_TTBY
                    + "schan=140&os=1&campaign=138083&idfa=" + idfa + "&ip=" + ip
                    + "&callback=" + appPortUtil.back(channel, idfa, ip);
            clickRun.run(AppCodeConst.XZ_A1, AppStUrlConst.URL_XZ_A1, channel);
            INFO_XZ_A1.setAppId(appid);
            INFO_XZ_A1.setChannel(channel);
            INFO_XZ_A1.setIdfa(idfa);
            INFO_XZ_A1.setIp(ip);
            INFO_XZ_A1.setCallback(callback);
            cacheUtil.saveInfo(INFO_XZ_A1);
            skipYxfService.click(AppCodeConst.YXF_A1, idfa, ip, BindChannelConst.CHANNEL_2101);
            skipYzService.click(AppCodeConst.YZ_A1, idfa, ip, BindChannelConst.CHANNEL_1801);
            skipFdService.click(AppCodeConst.FD_A1, idfa, ip, BindChannelConst.CHANNEL_1901);
        }
        //app:xzA2  channel:1602
        if (appid.equals(AppCodeConst.XZ_A2)) {
            AppStUrlConst.URL_XZ_A2 = AppUrlConst.URL_TTBY
                    + "schan=140&os=1&campaign=138084&idfa=" + idfa + "&ip=" + ip
                    + "&callback=" + appPortUtil.back(channel, idfa, ip);
            clickRun.run(AppCodeConst.XZ_A2, AppStUrlConst.URL_XZ_A2, channel);
            INFO_XZ_A2.setAppId(appid);
            INFO_XZ_A2.setChannel(channel);
            INFO_XZ_A2.setIdfa(idfa);
            INFO_XZ_A2.setIp(ip);
            INFO_XZ_A2.setCallback(callback);
            cacheUtil.saveInfo(INFO_XZ_A2);
            skipYxfService.click(AppCodeConst.YXF_A2, idfa, ip, BindChannelConst.CHANNEL_2102);
            skipFdService.click(AppCodeConst.FD_A6, idfa, ip, BindChannelConst.CHANNEL_1906);
        }
        //app:xzA4  channel:1604
        if (appid.equals(AppCodeConst.XZ_A4)) {
            AppStUrlConst.URL_XZ_A4 = AppUrlConst.URL_TTBY
                    + "schan=140&os=1&campaign=138981&idfa=" + idfa + "&ip=" + ip
                    + "&callback=" + appPortUtil.back(channel, idfa, ip);
            clickRun.run(AppCodeConst.XZ_A4, AppStUrlConst.URL_XZ_A4, channel);
            INFO_XZ_A2.setAppId(appid);
            INFO_XZ_A2.setChannel(channel);
            INFO_XZ_A2.setIdfa(idfa);
            INFO_XZ_A2.setIp(ip);
            INFO_XZ_A2.setCallback(callback);
            cacheUtil.saveInfo(INFO_XZ_A4);
            skipFdService.click(AppCodeConst.FD_A8, idfa, ip, BindChannelConst.CHANNEL_1908);
        }
    }
}
