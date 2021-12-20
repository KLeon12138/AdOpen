package com.leon.adopen.dock.task;

import cn.hutool.core.date.DateUtil;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.dock.init.InitDate;
import com.leon.adopen.domain.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * @author leon
 * @date 2021-12-20 17:43
 */
@Component
@Slf4j
@Validated
public class UpdateTimeTask {
    @Resource
    private InitDate initDate;

    @Scheduled(cron = "0 0 0 * * ?")
    public void initClickCount() throws Exception {
        log.info("[定时任务初始化产品点击], now -> {}, yestday -> {}", DateUtil.now(), DateUtils.getSecondDay());
        initDate.run();
        log.info("[初始化当天日期,执行完成,今日:{}]", InitDateConstants.DATE_TODAY);
        log.info("[初始化当天日期(简写),执行完成,今日:{}]", InitDateConstants.DATE_SHORT_TODAY);
    }
}
