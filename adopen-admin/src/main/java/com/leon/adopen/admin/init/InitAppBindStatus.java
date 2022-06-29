package com.leon.adopen.admin.init;

import com.leon.adopen.common.constants.app.AppBindStatusConst;
import com.leon.adopen.common.constants.app.AppCodeConst;
import com.leon.adopen.common.constants.app.AppComConst;
import com.leon.adopen.domain.dao.AppBindDao;
import com.leon.adopen.domain.entity.AppBind;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author leon
 * @date 2021-12-20 15:58
 */
@Component
@Slf4j
public class InitAppBindStatus implements CommandLineRunner {
    @Resource
    private AppBindDao appBindDao;

    @Override
    public void run(String... args) {
        List<AppBind> appBindList = appBindDao.findAllByIsdel(AppComConst.APP_BIND_NOT_DEL);
        for (AppBind bind : appBindList) {
            if (bind.getAppCode().equals(AppCodeConst.DTS_A1)) {
                AppBindStatusConst.BIND_DTS_A1 = bind.getIsOnStatus();
            }
            if (bind.getAppCode().equals(AppCodeConst.DTS_A2)) {
                AppBindStatusConst.BIND_DTS_A2 = bind.getIsOnStatus();
            }
            if (bind.getAppCode().equals(AppCodeConst.DTS_A3)) {
                AppBindStatusConst.BIND_DTS_A3 = bind.getIsOnStatus();
            }
            if (bind.getAppCode().equals(AppCodeConst.DTS_A4)) {
                AppBindStatusConst.BIND_DTS_A4 = bind.getIsOnStatus();
            }
            if (bind.getAppCode().equals(AppCodeConst.DTS_A5)) {
                AppBindStatusConst.BIND_DTS_A5 = bind.getIsOnStatus();
            }
            if (bind.getAppCode().equals(AppCodeConst.DZG_A1)) {
                AppBindStatusConst.BIND_DZG_A1 = bind.getIsOnStatus();
            }
            if (bind.getAppCode().equals(AppCodeConst.DZG_A2)) {
                AppBindStatusConst.BIND_DZG_A2 = bind.getIsOnStatus();
            }
            if (bind.getAppCode().equals(AppCodeConst.DZG_A3)) {
                AppBindStatusConst.BIND_DZG_A3 = bind.getIsOnStatus();
            }
            if (bind.getAppCode().equals(AppCodeConst.DZG_A4)) {
                AppBindStatusConst.BIND_DZG_A4 = bind.getIsOnStatus();
            }
            if (bind.getAppCode().equals(AppCodeConst.DZG_A5)) {
                AppBindStatusConst.BIND_DZG_A5 = bind.getIsOnStatus();
            }
        }
    }
}
