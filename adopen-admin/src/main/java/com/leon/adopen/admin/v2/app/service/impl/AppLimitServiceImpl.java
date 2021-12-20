package com.leon.adopen.admin.v2.app.service.impl;

import com.leon.adopen.admin.v2.app.service.AppLimitService;
import com.leon.adopen.common.constants.app.AppCodeConstants;
import com.leon.adopen.common.constants.app.AppLimitConstants;
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
    public Integer updateLimit(String appCode, Integer limit) {
        if (appCode.equals(AppCodeConstants.YDWX_A1)) {
            AppLimitConstants.LIMIT_YDWX_A1 = limit;
            return AppLimitConstants.LIMIT_YDWX_A1;
        }
        return AppLimitConstants.DEFAULT_APP_LIMIT;
    }
}
