package com.leon.adopen.admin.init;

import com.leon.adopen.common.constants.app.AppCodeConst;
import com.leon.adopen.common.constants.app.AppLimitConst;
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
        AppLimitConst.LIMIT_YZ_A1 = appManager.limitForApp(AppCodeConst.YZ_A1).longValue();
        AppLimitConst.LIMIT_YZ_A2 = appManager.limitForApp(AppCodeConst.YZ_A2).longValue();
    }
}
