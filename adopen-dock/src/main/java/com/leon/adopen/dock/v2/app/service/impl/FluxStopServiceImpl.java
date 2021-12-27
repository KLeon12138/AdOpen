package com.leon.adopen.dock.v2.app.service.impl;

import com.leon.adopen.common.constants.app.AppBindStatusConstants;
import com.leon.adopen.common.constants.app.AppCodeConstants;
import com.leon.adopen.common.constants.app.AppComConstants;
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
        appBindDao.updateAppBindStatusByChannelCode(appCode, AppComConstants.APP_BIND_STATUS_DOWN);
    }

    /**
     * update current server status
     *
     * @param appCode 产品编码
     */
    private void stopCurrentServerStatus(String appCode) {
        if (appCode.equals(AppCodeConstants.PPSG_A1)) {
            AppBindStatusConstants.BIND_PPSG_A1 = false;
        }
        if (appCode.equals(AppCodeConstants.PPSG_A2)) {
            AppBindStatusConstants.BIND_PPSG_A2 = false;
        }
        if (appCode.equals(AppCodeConstants.FDDS_A1)) {
            AppBindStatusConstants.BIND_FDDS_A1 = false;
        }
        if (appCode.equals(AppCodeConstants.FDDS_A2)) {
            AppBindStatusConstants.BIND_FDDS_A2 = false;
        }
    }
}
