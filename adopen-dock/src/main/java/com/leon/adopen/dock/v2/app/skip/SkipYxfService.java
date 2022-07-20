package com.leon.adopen.dock.v2.app.skip;

import com.leon.adopen.common.constants.app.AppClickConst;
import com.leon.adopen.common.constants.app.AppCodeConst;
import com.leon.adopen.common.constants.app.AppStUrlConst;
import com.leon.adopen.common.constants.app.AppUrlConst;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.utils.AppPortUtil;
import com.leon.adopen.common.utils.CheckAppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 游小福
 *
 * @author leon
 * @date 2022-06-28 00:51
 */
@Service
@Slf4j
public class SkipYxfService {
    @Resource
    private AppPortUtil appPortUtil;
    @Resource
    private CheckAppUtils checkAppUtils;
    @Resource
    private SkipRun skipRun;


    public void click(String appid, String idfa, String ip, String channel) throws Exception {
        //app:yxfA1  channel:2101
        if (appid.equals(AppCodeConst.YXF_A1)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.YXF_A1, AppClickConst.CLICK_2101, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_YXF_A1 = AppUrlConst.URL_TTBY
                        + "schan=140&os=1&campaign=138385&idfa=" + idfa + "&ip=" + ip
                        + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.YXF_A1, AppStUrlConst.URL_YXF_A1, channel);
            }
        }
        //app:yxfA2  channel:2102
        if (appid.equals(AppCodeConst.YXF_A2)) {
            if (!checkAppUtils.checkLimitFull(AppCodeConst.YXF_A2, AppClickConst.CLICK_2102, InitDateConstants.DATE_TODAY)) {
                AppStUrlConst.URL_YXF_A2 = AppUrlConst.URL_TTBY
                        + "schan=140&os=1&campaign=138385&idfa=" + idfa + "&ip=" + ip
                        + "&callback=" + appPortUtil.backToMe(channel, idfa, ip);
                skipRun.run(AppCodeConst.YXF_A2, AppStUrlConst.URL_YXF_A2, channel);
            }
        }
    }
}
