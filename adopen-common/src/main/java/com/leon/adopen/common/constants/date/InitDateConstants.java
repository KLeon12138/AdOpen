package com.leon.adopen.common.constants.date;

import cn.hutool.core.date.DateUtil;
import com.leon.adopen.domain.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;


/**
 * 接口前缀常量
 *
 * @author leon
 * @date 2019-05-02
 */
@Component
@Slf4j
@EnableScheduling
public class InitDateConstants {
    /**
     * 当天日期(精确到天)
     */
    public static String DATE_TODAY = "";
    /**
     * 前一天日期-开始日期(精确到秒)
     */
    public static String DATE_BEFORE_DAY_START = "";
    /**
     * 前一天日期-结束日期(精确到秒)
     */
    public static String DATE_BEFORE_DAY_END = "";
    /**
     * 当前日期(简写)
     */
    public static String DATE_SHORT_TODAY = "";


    /**
     * 每天整点执行定时任务
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void initTodayDate() throws ParseException {
        log.info("[定时任务-初始化时间, 执行时间:{}]", DateUtil.now());

        DATE_TODAY = DateUtils.getShortNow();
        log.info("[定时任务-初始化当天时间，今日:{}]", DATE_TODAY);

        DATE_SHORT_TODAY = DateUtils.getShortNowNoChar();
        log.info("[定时任务-初始化当天时间(简写)，今日:{}]", DATE_SHORT_TODAY);

        DATE_BEFORE_DAY_START = DateUtils.getShortBeforeStartDate();
        log.info("[定时任务-初始化前一天开始时间,执行完成:{}]", DATE_BEFORE_DAY_START);

        DATE_BEFORE_DAY_END = DateUtils.getShortBeforeEndDate();
        log.info("[定时任务-初始化前一天结束时间,执行完成:{}]", DATE_BEFORE_DAY_END);
    }
}
