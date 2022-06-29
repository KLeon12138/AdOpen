package com.leon.adopen.task.click.service.impl;

import com.alibaba.fastjson.JSON;
import com.leon.adopen.common.constants.app.AppComConst;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.constants.symbol.NumberConstants;
import com.leon.adopen.common.constants.symbol.SymbolConstants;
import com.leon.adopen.common.exception.code.ExCode;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.common.utils.StringUtils;
import com.leon.adopen.domain.dao.*;
import com.leon.adopen.domain.entity.*;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import com.leon.adopen.domain.redis.AdopenCacheConstants;
import com.leon.adopen.domain.redis.AdopenCacheUtil;
import com.leon.adopen.domain.util.DateUtils;
import com.leon.adopen.task.click.service.AppClickTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author leon
 * @date 2021-12-22 16:40
 */
@Service
@Slf4j
public class AppClickTaskServiceImpl implements AppClickTaskService {
    @Resource
    private AdopenCacheUtil adopenCacheUtil;
    @Resource
    private AppClickDao appClickDao;
    @Resource
    private AppBindDao appBindDao;
    @Resource
    private AppDao appDao;
    @Resource
    private SpDao spDao;
    @Resource
    private CpDao cpDao;

    /**
     * 刷新产品点击
     *
     * @param shortNowNoChar 短字符日期
     * @throws AdopenDbException 空数据异常
     */
    @Override
    public Object refreshClick(String shortNowNoChar) throws AdopenDbException {
        Map<String, Object> data = new HashMap<>(16);
        if (StringUtils.isEmpty(shortNowNoChar)) {
            shortNowNoChar = DateUtils.getShortNowNoChar();
        }
        List<String> clickKeys = adopenCacheUtil.takeDataByFuzzyKey(AdopenCacheConstants.KEY_CLICK + ":" + shortNowNoChar);
        data.put("clickKeys", JSON.toJSONString(clickKeys));
        log.info("[需要更新的key], click keys:[{}]", JSON.toJSONString(clickKeys));
        for (String key : clickKeys) {
            if (key.isEmpty() || !key.contains(SymbolConstants.SPLIT_INDEX)) {
                log.error("[参数非法]，key:[{}]", key);
                continue;
            }
            List<String> splitString = Arrays.asList(key.split(SymbolConstants.SPLIT_INDEX));
            if (StringUtils.isEmpty(shortNowNoChar)) {
                if (!splitString.get(NumberConstants.INDEX_TWO).equals(InitDateConstants.DATE_SHORT_TODAY)) {
                    log.info("[实际日期] -> {}, [缓存日期] -> {}", InitDateConstants.DATE_SHORT_TODAY, splitString.get(NumberConstants.INDEX_TWO));
                    log.error("[日期不合法]，key.time:[{}]", splitString.get(NumberConstants.INDEX_TWO));
                    continue;
                }
            }
            AppClick appClick = appClickDao.findByChannelCodeAndClickDate(splitString.get(NumberConstants.INDEX_THREE), InitDateConstants.DATE_TODAY);
            if (StringUtils.isEmpty(appClick)) {
                log.error("[该缓存无对应数据], data:[{}], key -> {}", JSON.toJSONString(appClick), key);
                continue;
            }
            Integer clickCount = Integer.parseInt(adopenCacheUtil.getData(key));
            appClick.setClickCount(clickCount);
            appClickDao.saveAndFlush(appClick);
            log.info("[更新点击成功],app id:[{}], app name:[{}], channelCode:[{}], click:[{}], ctime:[{}]", appClick.getAppId(), appClick.getAppName(), appClick.getChannelCode(), clickCount, appClick.getClickDate());
        }
        return data;
    }

    /**
     * 初始化产品点击
     *
     * @param date 点击日期
     * @return {@link  List<AppClick> } 产品点击记录
     * @throws AdopenException 空数据异常
     */
    @Override
    public List<AppClick> initClick(String date) throws AdopenException {
        List<AppBind> appBinds = appBindDao.findAllByIsdel(AppComConst.APP_BIND_NOT_DEL);
        if (appBinds.size() == NumberConstants.SIZE_ZERO) {
            throw new AdopenException(ExCode.queryDataFailed, "分配产品为空");
        }
        List<AppClick> appClicks = new ArrayList<>();
        for (AppBind appBind : appBinds) {
            AppClick appClick = this.appClickBuilder(appBind, date);
            appClickDao.save(appClick);
            appClicks.add(appClick);
        }
        return appClicks;
    }

    /**
     * 产品点击记录构造器
     *
     * @param appBind 产品分配记录
     * @param date    产品点击日期
     * @return {@link  AppClick}   产品点击记录
     * @throws AdopenException 数据空异常
     */
    private AppClick appClickBuilder(AppBind appBind, String date) throws AdopenException {
        App app = appDao.findById(appBind.getAppId()).orElse(null);
        if (StringUtils.isEmpty(app)) {
            throw new AdopenException(ExCode.queryDataFailed, "无该产品;产品id:" + appBind.getAppId());
        }
        Sp sp = spDao.findById(appBind.getSpId()).orElse(null);
        if (StringUtils.isEmpty(sp)) {
            throw new AdopenException(ExCode.queryDataFailed, "无该sp信息;sp id:" + appBind.getSpId());
        }
        Cp cp = cpDao.findById(appBind.getCpId()).orElse(null);
        if (StringUtils.isEmpty(cp)) {
            throw new AdopenException(ExCode.queryDataFailed, "无该cp信息;cp id:" + appBind.getCpId());
        }
        if (appClickDao.existsByChannelCodeAndClickDate(appBind.getChannelCode(), InitDateConstants.DATE_SHORT_TODAY)) {
            throw new AdopenException(ExCode.repeatData, "今日已有该产品点击记录");
        }
        return AppClick.builder()
                .appId(app.getId())
                .appCode(app.getAppCode())
                .appName(app.getAppName())
                .spId(sp.getId())
                .spName(sp.getName())
                .cpId(cp.getId())
                .cpName(cp.getName())
                .channelCode(appBind.getChannelCode())
                .limitDay(app.getLimitDay())
                .clickDate(date).build();
    }
}
