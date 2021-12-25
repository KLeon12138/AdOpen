package com.leon.adopen.admin.v2.app.service;

import com.leon.adopen.admin.v2.app.request.AppListRequest;
import com.leon.adopen.admin.v2.app.request.AppSaveRequest;
import com.leon.adopen.admin.v2.app.vo.AppListVoPage;
import com.leon.adopen.admin.v2.app.vo.AppPullDownVo;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.common.vo.page.JsonPage;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * app-service
 *
 * @author leon
 * @date 2021-12-16 11:50
 */
public interface AppService {
    /**
     * 产品列表
     *
     * @param request 产品列表请求数据
     * @param page    分页信息
     * @return {@link  AppListVoPage}  产品分页数据
     */
    AppListVoPage listApp(AppListRequest request, JsonPage<T> page);

    /**
     * 新增产品
     *
     * @param request 产品保存请求数据
     * @throws AdopenException 入参请求异常或数据重复异常
     */
    void saveApp(AppSaveRequest request) throws AdopenException;

    /**
     * 产品下拉数据
     *
     * @return {@link  List<AppPullDownVo>}    产品下拉数据
     */
    List<AppPullDownVo> pullDownApp();
}
