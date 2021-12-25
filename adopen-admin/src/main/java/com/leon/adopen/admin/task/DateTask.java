package com.leon.adopen.admin.task;

import cn.hutool.core.date.DateUtil;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.domain.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.text.ParseException;

/**
 * @author leon
 * @date 2021-12-25 09:52
 */
@Component
@Slf4j
@Validated
public class DateTask {
    /**
     * 每天整点执行定时任务
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void initTodayDate() throws ParseException {
        log.info("[定时任务-初始化时间, 执行时间:{}]", DateUtil.now());

        InitDateConstants.DATE_TODAY = DateUtils.getShortNow();
        log.info("[定时任务-初始化当天时间，今日:{}]", InitDateConstants.DATE_TODAY);

        InitDateConstants.DATE_SHORT_TODAY = DateUtils.getShortNowNoChar();
        log.info("[定时任务-初始化当天时间(简写)，今日:{}]", InitDateConstants.DATE_SHORT_TODAY);

        InitDateConstants.DATE_BEFORE_DAY_START = DateUtils.getShortBeforeStartDate();
        log.info("[定时任务-初始化前一天开始时间,执行完成:{}]", InitDateConstants.DATE_BEFORE_DAY_START);

        InitDateConstants.DATE_BEFORE_DAY_END = DateUtils.getShortBeforeEndDate();
        log.info("[定时任务-初始化前一天结束时间,执行完成:{}]", InitDateConstants.DATE_BEFORE_DAY_END);
    }
}
