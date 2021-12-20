package com.leon.adopen.dock.init;

import cn.hutool.core.date.DateUtil;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.domain.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author leon
 * @date 2021-12-20 17:40
 */
@Component
@Slf4j
@Service
public class InitDate implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("[初始化日期,执行时间:{}]", DateUtil.now());

        InitDateConstants.DATE_TODAY = DateUtils.getShortNow();
        log.info("[初始化当天日期,执行完成,今日:{}]", InitDateConstants.DATE_TODAY);

        InitDateConstants.DATE_SHORT_TODAY = DateUtils.getShortNowNoChar();
        log.info("[初始化当天日期(简写),执行完成,今日:{}]", InitDateConstants.DATE_SHORT_TODAY);

        InitDateConstants.DATE_BEFORE_DAY_START = DateUtils.getShortBeforeStartDate();
        log.info("[初始化前一天开始时间,执行完成,{}]", InitDateConstants.DATE_BEFORE_DAY_START);

        InitDateConstants.DATE_BEFORE_DAY_END = DateUtils.getShortBeforeEndDate();
        log.info("[初始化前一天结束时间,执行完成,{}]", InitDateConstants.DATE_BEFORE_DAY_END);
    }
}
