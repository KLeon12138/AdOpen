package com.leon.adopen.dock.task;

import com.leon.adopen.common.constants.app.AppBindStatusConst;
import com.leon.adopen.common.constants.app.AppCodeConst;
import com.leon.adopen.common.constants.app.AppComConst;
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
        List<AppBind> appBindList = appBindDao.findAllByIsOnStatus(AppComConst.APP_BIND_STATUS_DOWN);
        List<String> appCodeList = new ArrayList<>();
        for (AppBind bind : appBindList) {
            appBindDao.updateAppBindStatusByChannelCode(bind.getChannelCode(), AppComConst.APP_BIND_STATUS_ON);
            appCodeList.add(bind.getAppCode());
            if (appCodeList.contains(AppCodeConst.DTS_A1)) {
                AppBindStatusConst.BIND_DTS_A1 = true;
            }
            if (appCodeList.contains(AppCodeConst.DTS_A2)) {
                AppBindStatusConst.BIND_DTS_A2 = true;
            }
            if (appCodeList.contains(AppCodeConst.DTS_A3)) {
                AppBindStatusConst.BIND_DTS_A3 = true;
            }
            if (appCodeList.contains(AppCodeConst.DTS_A4)) {
                AppBindStatusConst.BIND_DTS_A4 = true;
            }
            if (appCodeList.contains(AppCodeConst.DTS_A5)) {
                AppBindStatusConst.BIND_DTS_A5 = true;
            }
            if (appCodeList.contains(AppCodeConst.DZG_A1)) {
                AppBindStatusConst.BIND_DZG_A1 = true;
            }
            if (appCodeList.contains(AppCodeConst.DZG_A2)) {
                AppBindStatusConst.BIND_DZG_A2 = true;
            }
            if (appCodeList.contains(AppCodeConst.DZG_A3)) {
                AppBindStatusConst.BIND_DZG_A3 = true;
            }
            if (appCodeList.contains(AppCodeConst.DZG_A4)) {
                AppBindStatusConst.BIND_DZG_A4 = true;
            }
            if (appCodeList.contains(AppCodeConst.DZG_A5)) {
                AppBindStatusConst.BIND_DZG_A5 = true;
            }
        }
    }
}
