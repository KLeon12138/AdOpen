package com.leon.adopen.dock.v2.app.service.impl;

import com.leon.adopen.common.constants.app.AppBindStatusConst;
import com.leon.adopen.common.constants.app.AppCodeConst;
import com.leon.adopen.common.constants.app.AppComConst;
import com.leon.adopen.dock.v2.app.service.FluxStopService;
import com.leon.adopen.domain.dao.AppBindDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 产品停量-impl
 *
 * @author leon
 * @date 2021-12-20 16:20
 */
@Service
public class FluxStopServiceImpl implements FluxStopService {
    @Resource
    private AppBindDao appBindDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void checkToStop(String appCode) {
        this.stopCurrentServerStatus(appCode);
        appBindDao.updateAppBindStatusByChannelCode(appCode, AppComConst.APP_BIND_STATUS_DOWN);
    }

    /**
     * update current server status
     *
     * @param appCode 产品编码
     */
    private void stopCurrentServerStatus(String appCode) {
        if (appCode.equals(AppCodeConst.DTS_A1)) {
            AppBindStatusConst.BIND_DTS_A1 = false;
        }
        if (appCode.equals(AppCodeConst.DTS_A2)) {
            AppBindStatusConst.BIND_DTS_A2 = false;
        }
        if (appCode.equals(AppCodeConst.DTS_A3)) {
            AppBindStatusConst.BIND_DTS_A3 = false;
        }
        if (appCode.equals(AppCodeConst.DTS_A4)) {
            AppBindStatusConst.BIND_DTS_A4 = false;
        }
        if (appCode.equals(AppCodeConst.DTS_A5)) {
            AppBindStatusConst.BIND_DTS_A5 = false;
        }
        if (appCode.equals(AppCodeConst.DZG_A1)) {
            AppBindStatusConst.BIND_DZG_A1 = false;
        }
        if (appCode.equals(AppCodeConst.DZG_A2)) {
            AppBindStatusConst.BIND_DZG_A2 = false;
        }
        if (appCode.equals(AppCodeConst.DZG_A3)) {
            AppBindStatusConst.BIND_DZG_A3 = false;
        }
        if (appCode.equals(AppCodeConst.DZG_A4)) {
            AppBindStatusConst.BIND_DZG_A4 = false;
        }
        if (appCode.equals(AppCodeConst.DZG_A5)) {
            AppBindStatusConst.BIND_DZG_A5 = false;
        }
    }
}
