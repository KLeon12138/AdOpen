package com.leon.adopen.admin.v2.app.service;

import com.leon.adopen.admin.v2.app.request.AppBindListRequest;
import com.leon.adopen.admin.v2.app.request.AppBindAllotRequest;
import com.leon.adopen.admin.v2.app.vo.AppBindListVoPage;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.common.vo.page.JsonPage;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author leon
 * @date 2021-12-20 16:12
 */
public interface AppBindService {
    /**
     * 产品绑定列表
     *
     * @param request 产品绑定列表-request
     * @param page    分页信息
     * @return {@link  AppBindListVoPage}  产品绑定列表-page
     */
    AppBindListVoPage listAppBind(AppBindListRequest request, JsonPage<T> page);

    /**
     * 产品绑定-分配
     *
     * @param request 产品绑定分配-request
     * @throws AdopenException 入参空、数据重复、数据无效等异常
     */
    void allot(AppBindAllotRequest request) throws AdopenException;

    /**
     * 更新产品绑定上线状态
     *
     * @param appCode 产品编码
     * @param isOn    产品
     * @return {@link  Boolean}    上线状态
     */
    Boolean updateIsOn(String appCode, Boolean isOn);
}
