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
        return limit;
    }
}
