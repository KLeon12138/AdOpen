package com.leon.adopen.common.constants.date;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


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
}
