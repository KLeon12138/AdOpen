package com.leon.adopen.dock.task;

import com.leon.adopen.common.constants.app.AppClickConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * 初始化产品量
 *
 * @author leon
 * @date 2019-12-23 23:37
 */
@Component
@Slf4j
@Validated
public class RefreshAppClickTask {
    @Scheduled(cron = "0 0 0 * * ?")
    public void updateAppStatusMid() {
        AppClickConst.CLICK_1801 = 0L;
        AppClickConst.CLICK_1802 = 0L;
        AppClickConst.CLICK_1803 = 0L;
        AppClickConst.CLICK_1804 = 0L;
        AppClickConst.CLICK_1805 = 0L;
        AppClickConst.CLICK_1806 = 0L;
        AppClickConst.CLICK_1807 = 0L;
    }
}
