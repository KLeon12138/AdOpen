package com.leon.adopen.admin.init;

import com.leon.adopen.common.constants.app.AppCodeConstants;
import com.leon.adopen.common.constants.app.AppLimitConstants;
import com.leon.adopen.domain.manager.AppManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author leon
 * @date 2021-12-20 14:51
 */
@Component
@Slf4j
public class InitAppLimit implements CommandLineRunner {
    @Resource
    private AppManager appManager;

    @Override
    public void run(String... args) throws Exception {
        AppLimitConstants.LIMIT_PPSG_A1 = appManager.limitForApp(AppCodeConstants.PPSG_A1);
        AppLimitConstants.LIMIT_PPSG_A2 = appManager.limitForApp(AppCodeConstants.PPSG_A2);
        AppLimitConstants.LIMIT_FDDS_A1 = appManager.limitForApp(AppCodeConstants.FDDS_A1);
        AppLimitConstants.LIMIT_FDDS_A2 = appManager.limitForApp(AppCodeConstants.FDDS_A2);
    }
}
