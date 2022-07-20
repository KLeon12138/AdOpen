package com.leon.adopen.dock.v2.app.servicemark;

import com.leon.adopen.common.constants.app.AppCodeConst;
import com.leon.adopen.common.constants.app.AppStUrlConst;
import com.leon.adopen.common.constants.app.AppUrlConst;
import com.leon.adopen.common.utils.AppPortUtil;
import com.leon.adopen.domain.pojo.BaseInfo;
import com.leon.adopen.domain.redis.AdopenCacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 王国纪元
 *
 * @author leon
 * @date 2022-07-07 14:00
 */
@Service
@Slf4j
public class ClickWgService {
    @Resource
    private AdopenCacheUtil cacheUtil;
    @Resource
    private AppPortUtil appPortUtil;
    @Resource
    private ClickRun clickRun;

    private static final BaseInfo INFO_WG_A2 = new BaseInfo();

    @Async
    public void click(String appid, String idfa, String ip, String channel, String callback) throws Exception {
        //app:wgA2  channel:2002
        if (appid.equals(AppCodeConst.WG_A2)) {
            AppStUrlConst.URL_WG_A2 = AppUrlConst.URL_TTBY
                    + "schan=140&os=1&campaign=139249&idfa=" + idfa + "&ip=" + ip
                    + "&callback=" + appPortUtil.back(channel, idfa, ip);
            clickRun.run(AppCodeConst.WG_A2, AppStUrlConst.URL_WG_A2, channel);
            INFO_WG_A2.setAppId(appid);
            INFO_WG_A2.setChannel(channel);
            INFO_WG_A2.setIdfa(idfa);
            INFO_WG_A2.setIp(ip);
            INFO_WG_A2.setCallback(callback);
            cacheUtil.saveInfo(INFO_WG_A2);
        }
    }
}
