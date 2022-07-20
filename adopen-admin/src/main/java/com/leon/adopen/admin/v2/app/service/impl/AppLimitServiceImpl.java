package com.leon.adopen.admin.v2.app.service.impl;

import com.leon.adopen.admin.v2.app.service.AppLimitService;
import com.leon.adopen.common.constants.app.AppCodeConst;
import com.leon.adopen.common.constants.app.AppLimitConst;
import org.springframework.stereotype.Service;

/**
 * app限量-impl
 *
 * @author leon
 * @date 2021-12-20 15:09
 */
@Service
public class AppLimitServiceImpl implements AppLimitService {
    @Override
    public Long updateLimit(String appCode, Long limit) {
        if (appCode.equals(AppCodeConst.YZ_A1)) {
            AppLimitConst.LIMIT_YZ_A1 = limit;
        }
        if (appCode.equals(AppCodeConst.YZ_A2)) {
            AppLimitConst.LIMIT_YZ_A2 = limit;
        }
        if (appCode.equals(AppCodeConst.YZ_A3)) {
            AppLimitConst.LIMIT_YZ_A3 = limit;
        }
        if (appCode.equals(AppCodeConst.YZ_A4)) {
            AppLimitConst.LIMIT_YZ_A4 = limit;
        }
        if (appCode.equals(AppCodeConst.YZ_A5)) {
            AppLimitConst.LIMIT_YZ_A5 = limit;
        }
        if (appCode.equals(AppCodeConst.FD_A1)) {
            AppLimitConst.LIMIT_FD_A1 = limit;
        }
        if (appCode.equals(AppCodeConst.FD_A2)) {
            AppLimitConst.LIMIT_FD_A2 = limit;
        }
        if (appCode.equals(AppCodeConst.FD_A3)) {
            AppLimitConst.LIMIT_FD_A3 = limit;
        }
        if (appCode.equals(AppCodeConst.FD_A4)) {
            AppLimitConst.LIMIT_FD_A4 = limit;
        }
        if (appCode.equals(AppCodeConst.FD_A5)) {
            AppLimitConst.LIMIT_FD_A5 = limit;
        }
        if (appCode.equals(AppCodeConst.FD_A6)) {
            AppLimitConst.LIMIT_FD_A6 = limit;
        }
        if (appCode.equals(AppCodeConst.FD_A7)) {
            AppLimitConst.LIMIT_FD_A7 = limit;
        }
        if (appCode.equals(AppCodeConst.FD_A8)) {
            AppLimitConst.LIMIT_FD_A8 = limit;
        }
        if (appCode.equals(AppCodeConst.YXF_A1)) {
            AppLimitConst.LIMIT_YXF_A1 = limit;
        }
        if (appCode.equals(AppCodeConst.YXF_A2)) {
            AppLimitConst.LIMIT_YXF_A2 = limit;
        }
        if (appCode.equals(AppCodeConst.JP_A1)) {
            AppLimitConst.LIMIT_JP_A1 = limit;
        }
        if (appCode.equals(AppCodeConst.JP_A2)) {
            AppLimitConst.LIMIT_JP_A2 = limit;
        }
        return limit;
    }
}
