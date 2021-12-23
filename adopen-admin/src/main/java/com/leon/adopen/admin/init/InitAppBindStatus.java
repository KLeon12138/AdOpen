package com.leon.adopen.admin.init;

import com.leon.adopen.common.constants.app.AppBindStatusConstants;
import com.leon.adopen.common.constants.app.AppCodeConstants;
import com.leon.adopen.common.constants.app.AppComConstants;
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
        List<AppBind> appBindList = appBindDao.findAllByIsdel(AppComConstants.APP_BIND_NOT_DEL);
        for (AppBind bind : appBindList) {
            if (bind.getAppCode().equals(AppCodeConstants.YDWX_A1)) {
                AppBindStatusConstants.BIND_YDWX_A1 = bind.getIsOnStatus();
            }
        }
    }
}
