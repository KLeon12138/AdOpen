package com.leon.adopen.admin.v2.app.service;

import com.leon.adopen.admin.v2.app.request.AppClickRequest;
import com.leon.adopen.admin.v2.app.vo.AppClickListVoPage;
import com.leon.adopen.common.vo.page.JsonPage;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author leon
 * @date 2021-12-26 22:07
 */
public interface AppClickService {
    /**
     * 产品点击列表
     *
     * @param request 产品点击-request
     * @param page    分页信息
     * @return {@link  AppClickListVoPage}  产品点击列表
     */
    AppClickListVoPage listClick(AppClickRequest request, JsonPage<T> page);

    /**
     * 刷新产品点击
     *
     * @param shortNowNoChar 点击日期
     * @throws AdopenDbException 缓存失效、更新失败等异常
     */
    void refresh(String shortNowNoChar) throws AdopenDbException;
}
