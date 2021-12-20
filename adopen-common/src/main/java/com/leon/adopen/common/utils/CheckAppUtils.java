package com.leon.adopen.common.utils;

import com.leon.adopen.common.constants.app.AppBindStatusConstants;
import com.leon.adopen.common.constants.app.AppCodeConstants;
import com.leon.adopen.common.constants.app.AppComConstants;
import com.leon.adopen.common.constants.app.AppLimitConstants;
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
     * @return 是否满量
     */
    public Boolean checkLimitFull(String appCode, Integer channelFlux, String date) {
        Integer limit = null;
        boolean result = false;
        try {
            limit = this.checkLimit(appCode);
            log.info("appCode -> {}, currentCount -> {}, limit -> {}", appCode, channelFlux, limit);
            result = channelFlux.compareTo(limit) >= 0;
        } catch (Exception e) {
            log.error("appCode -> {}, date -> {}, currentCount -> {}, limit ->{}", appCode, date, channelFlux, limit);
            log.error("error message -> {}", e.getMessage());
        }
        return result;
    }

    /**
     * 查询产品限量
     *
     * @param appCode 产品编码
     * @return {@link  Integer}    产品限量
     */
    private Integer checkLimit(String appCode) {
        if (appCode.equals(AppCodeConstants.YDWX_A1)) {
            return AppLimitConstants.LIMIT_YDWX_A1;
        }
        return AppLimitConstants.DEFAULT_APP_LIMIT;
    }

    /**
     * 校验产品绑定上线状态
     *
     * @param appCode 产品编码
     * @return 产品绑定上线状态
     */
    public Boolean checkAppBindIsOn(String appCode) {
        if (appCode.equals(AppCodeConstants.YDWX_A1)) {
            return AppBindStatusConstants.BIND_YDWX_A1;
        }
        return AppComConstants.APP_BIND_STATUS_DOWN;
    }
}
