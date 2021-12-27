package com.leon.adopen.dock.task;

import com.leon.adopen.common.constants.app.AppBindStatusConstants;
import com.leon.adopen.common.constants.app.AppCodeConstants;
import com.leon.adopen.common.constants.app.AppComConstants;
import com.leon.adopen.domain.dao.AppBindDao;
import com.leon.adopen.domain.entity.AppBind;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leon
 * @date 2021-12-20 16:53
 */
@Component
@Slf4j
@Validated
public class UpdateAppBindStatusTask {
    @Resource
    private AppBindDao appBindDao;

    @Scheduled(cron = "0 0 0 * * ?")
    public void updateAppBindIsOn() {
        List<AppBind> appBindList = appBindDao.findAllByIsOnStatus(AppComConstants.APP_BIND_STATUS_DOWN);
        List<String> appCodeList = new ArrayList<>();
        for (AppBind bind : appBindList) {
            appBindDao.updateAppBindStatusByChannelCode(bind.getChannelCode(), AppComConstants.APP_BIND_STATUS_ON);
            appCodeList.add(bind.getAppCode());
            if (appCodeList.contains(AppCodeConstants.PPSG_A1)) {
                AppBindStatusConstants.BIND_PPSG_A1 = true;
            }
            if (appCodeList.contains(AppCodeConstants.PPSG_A2)) {
                AppBindStatusConstants.BIND_PPSG_A2 = true;
            }
            if (appCodeList.contains(AppCodeConstants.FDDS_A1)) {
                AppBindStatusConstants.BIND_FDDS_A1 = true;
            }
            if (appCodeList.contains(AppCodeConstants.FDDS_A2)) {
                AppBindStatusConstants.BIND_FDDS_A2 = true;
            }
        }
    }
}
