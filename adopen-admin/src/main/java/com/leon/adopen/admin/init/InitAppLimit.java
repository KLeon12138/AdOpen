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
        AppLimitConst.LIMIT_YZ_A3 = appManager.limitForApp(AppCodeConst.YZ_A3).longValue();
        AppLimitConst.LIMIT_YZ_A4 = appManager.limitForApp(AppCodeConst.YZ_A4).longValue();
        AppLimitConst.LIMIT_YZ_A5 = appManager.limitForApp(AppCodeConst.YZ_A5).longValue();
        AppLimitConst.LIMIT_FD_A1 = appManager.limitForApp(AppCodeConst.FD_A1).longValue();
        AppLimitConst.LIMIT_FD_A2 = appManager.limitForApp(AppCodeConst.FD_A2).longValue();
        AppLimitConst.LIMIT_FD_A3 = appManager.limitForApp(AppCodeConst.FD_A3).longValue();
        AppLimitConst.LIMIT_FD_A4 = appManager.limitForApp(AppCodeConst.FD_A4).longValue();
        AppLimitConst.LIMIT_FD_A5 = appManager.limitForApp(AppCodeConst.FD_A5).longValue();
        AppLimitConst.LIMIT_FD_A6 = appManager.limitForApp(AppCodeConst.FD_A6).longValue();
        AppLimitConst.LIMIT_FD_A7 = appManager.limitForApp(AppCodeConst.FD_A7).longValue();
        AppLimitConst.LIMIT_FD_A8 = appManager.limitForApp(AppCodeConst.FD_A8).longValue();
        AppLimitConst.LIMIT_YXF_A1 = appManager.limitForApp(AppCodeConst.YXF_A1).longValue();
        AppLimitConst.LIMIT_YXF_A2 = appManager.limitForApp(AppCodeConst.YXF_A2).longValue();
        AppLimitConst.LIMIT_JP_A1 = appManager.limitForApp(AppCodeConst.JP_A1).longValue();
        AppLimitConst.LIMIT_JP_A2 = appManager.limitForApp(AppCodeConst.JP_A2).longValue();
    }
}
