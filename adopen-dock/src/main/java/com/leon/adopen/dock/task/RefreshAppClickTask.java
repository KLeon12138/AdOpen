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
        AppClickConst.CLICK_1901 = 0L;
        AppClickConst.CLICK_1902 = 0L;
        AppClickConst.CLICK_1903 = 0L;
        AppClickConst.CLICK_1904 = 0L;
        AppClickConst.CLICK_1905 = 0L;
        AppClickConst.CLICK_1906 = 0L;
        AppClickConst.CLICK_1907 = 0L;
        AppClickConst.CLICK_1908 = 0L;
        AppClickConst.CLICK_2101 = 0L;
        AppClickConst.CLICK_2102 = 0L;
        AppClickConst.CLICK_2201 = 0L;
        AppClickConst.CLICK_2202 = 0L;
    }
}
