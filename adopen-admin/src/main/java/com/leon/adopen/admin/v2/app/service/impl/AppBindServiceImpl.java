package com.leon.adopen.admin.v2.app.service.impl;

import com.leon.adopen.admin.v2.app.request.AppBindListRequest;
import com.leon.adopen.admin.v2.app.service.AppBindService;
import com.leon.adopen.admin.v2.app.vo.AppBindListVoPage;
import com.leon.adopen.common.constants.app.AppBindStatusConstants;
import com.leon.adopen.common.constants.app.AppCodeConstants;
import com.leon.adopen.common.vo.page.JsonPage;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

/**
 * @author leon
 * @date 2021-12-20 16:12
 */
@Service
public class AppBindServiceImpl implements AppBindService {
    @Override
    public Boolean updateIsOn(String appCode, Boolean isOn) {
        if (appCode.equals(AppCodeConstants.YDWX_A1)) {
            AppBindStatusConstants.BIND_YDWX_A1 = isOn;
            return AppBindStatusConstants.BIND_YDWX_A1;
        }
        return AppBindStatusConstants.DEFAULT_APP_BIND_STATUS;
    }

    @Override
    public AppBindListVoPage listAppBind(AppBindListRequest request, JsonPage<T> page) {
        return AppBindListVoPage.builder().build();
    }
}
