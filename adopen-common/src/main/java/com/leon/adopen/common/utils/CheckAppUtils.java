package com.leon.adopen.common.utils;

import com.leon.adopen.common.constants.app.AppBindStatusConst;
import com.leon.adopen.common.constants.app.AppCodeConst;
import com.leon.adopen.common.constants.app.AppComConst;
import com.leon.adopen.common.constants.app.AppLimitConst;
import com.leon.adopen.common.exception.example.AdopenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 校验产品属性
 *
 * @author leon
 * @date 2021-12-20 15:17
 */
@Slf4j
@Service
public class CheckAppUtils {
    /**
     * 校验量级
     *
     * @param appCode     产品编码
     * @param channelFlux 渠道现量
     * @param date        当前日期
     * @return 是否满量appStatusUtils
     */
    public Boolean checkLimitFull(String appCode, Long channelFlux, String date) {
        log.info("appCode -> {}, currentCount -> {}, limit -> {}, date -> {}", appCode, channelFlux, this.checkLimit(appCode), date);
        return channelFlux.compareTo(this.checkLimit(appCode)) >= 0;
    }

    /**
     * 查询产品限量
     *
     * @param appCode 产品编码
     * @return {@link  Integer}    产品限量
     */
    private Long checkLimit(String appCode) {
        if (appCode.equals(AppCodeConst.YZ_A1)) {
            return AppLimitConst.LIMIT_YZ_A1;
        }
        if (appCode.equals(AppCodeConst.YZ_A2)) {
            return AppLimitConst.LIMIT_YZ_A2;
        }
        return AppLimitConst.DEFAULT_APP_LIMIT;
    }

    /**
     * 校验产品绑定上线状态
     *
     * @param appCode 产品编码
     * @return 产品绑定上线状态
     */
    public Boolean checkAppBindIsOn(String appCode) {
        if (appCode.equals(AppCodeConst.DTS_A1)) {
            return AppBindStatusConst.BIND_DTS_A1;
        }
        if (appCode.equals(AppCodeConst.DTS_A2)) {
            return AppBindStatusConst.BIND_DTS_A2;
        }
        if (appCode.equals(AppCodeConst.DTS_A3)) {
            return AppBindStatusConst.BIND_DTS_A3;
        }
        if (appCode.equals(AppCodeConst.DTS_A4)) {
            return AppBindStatusConst.BIND_DTS_A4;
        }
        if (appCode.equals(AppCodeConst.DTS_A5)) {
            return AppBindStatusConst.BIND_DTS_A5;
        }
        if (appCode.equals(AppCodeConst.DZG_A1)) {
            return AppBindStatusConst.BIND_DZG_A1;
        }
        if (appCode.equals(AppCodeConst.DZG_A2)) {
            return AppBindStatusConst.BIND_DZG_A2;
        }
        if (appCode.equals(AppCodeConst.DZG_A3)) {
            return AppBindStatusConst.BIND_DZG_A3;
        }
        if (appCode.equals(AppCodeConst.DZG_A4)) {
            return AppBindStatusConst.BIND_DZG_A4;
        }
        if (appCode.equals(AppCodeConst.DZG_A5)) {
            return AppBindStatusConst.BIND_DZG_A5;
        }
        return AppComConst.APP_BIND_STATUS_DOWN;
    }
}
