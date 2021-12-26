package com.leon.adopen.admin.v2.app.service.impl;

import com.alibaba.fastjson.JSON;
import com.leon.adopen.admin.v2.app.request.AppClickRequest;
import com.leon.adopen.admin.v2.app.service.AppClickService;
import com.leon.adopen.admin.v2.app.vo.AppClickListVo;
import com.leon.adopen.admin.v2.app.vo.AppClickListVoPage;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.constants.symbol.NumberConstants;
import com.leon.adopen.common.constants.symbol.SymbolConstants;
import com.leon.adopen.common.jpa.JpaUtil;
import com.leon.adopen.common.utils.StringUtils;
import com.leon.adopen.common.vo.page.JsonPage;
import com.leon.adopen.domain.dao.AppClickDao;
import com.leon.adopen.domain.entity.AppClick;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import com.leon.adopen.domain.redis.AdopenCacheConstants;
import com.leon.adopen.domain.redis.AdopenCacheUtil;
import com.leon.adopen.domain.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author leon
 * @date 2021-12-26 22:37
 */
@Service
@Slf4j
public class AppClickServiceImpl implements AppClickService {
    @Resource
    private JpaUtil jpaUtil;
    @Resource
    private AdopenCacheUtil adopenCacheUtil;
    @Resource
    private AppClickDao appClickDao;

    /**
     * 产品点击列表
     *
     * @param request 产品点击-request
     * @param page    分页信息
     * @return {@link  AppClickListVoPage}  产品点击列表
     */
    @Override
    public AppClickListVoPage listClick(AppClickRequest request, JsonPage<T> page) {
        HashMap<String, Object> params = new HashMap<>(16);
        String hql = "select new com.leon.adopen.admin.v2.app.vo.AppClickListVo" +
                "(ac.appId, ac.appCode, ac.appName, ac.spName, ac.limitDay, ac.cpName, ac.channelCode, ac.clickCount, ac.clickDate) " +
                "from AppClick ac where 1 = 1 ";
        if (!StringUtils.isEmpty(request.getAppCode())) {
            hql += " and ac.appCode like :appCode";
            params.put("appCode", request.getAppCode());
        }
        if (!StringUtils.isEmpty(request.getChannelCode())) {
            hql += " and ac.channelCode like :channelCode";
            params.put("channelCode", request.getChannelCode());
        }
        if (!StringUtils.isEmpty(request.getClickDate())) {
            hql += " and ac.clickDate = :clickDate";
            params.put("clickDate", request.getClickDate());
        } else {
            hql += " and ac.clickDate = :clickDate";
            params.put("clickDate", InitDateConstants.DATE_TODAY);
        }
        Page<AppClickListVo> clickListVoPage = jpaUtil.page(hql, params, page.getPageableUnsorted(), AppClickListVo.class);
        return AppClickListVoPage.builder()
                .clickContent(clickListVoPage.getContent())
                .totalElements(clickListVoPage.getTotalElements())
                .totalPages(clickListVoPage.getTotalPages()).build();
    }

    /**
     * 刷新产品点击
     *
     * @param shortNowNoChar 点击日期
     * @throws AdopenDbException 缓存失效、更新失败等异常
     */
    @Override
    public void refresh(String shortNowNoChar) throws AdopenDbException {
        if (StringUtils.isEmpty(shortNowNoChar)) {
            shortNowNoChar = DateUtils.getShortNowNoChar();
        }
        List<String> clickKeys = adopenCacheUtil.takeDataByFuzzyKey(AdopenCacheConstants.KEY_CLICK + ":" + shortNowNoChar);
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
    }
}
