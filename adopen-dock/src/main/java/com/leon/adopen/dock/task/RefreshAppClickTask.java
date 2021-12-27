package com.leon.adopen.dock.task;

import com.leon.adopen.common.constants.app.AppClickConstants;
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
        AppClickConstants.CLICK_1201 = 0;
        AppClickConstants.CLICK_1202 = 0;
        AppClickConstants.CLICK_1301 = 0;
        AppClickConstants.CLICK_1302 = 0;
    }
}
