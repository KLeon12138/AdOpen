package com.leon.adopen.admin.v2.app.service;

import com.leon.adopen.admin.v2.app.request.AppBindListRequest;
import com.leon.adopen.admin.v2.app.vo.AppBindListVoPage;
import com.leon.adopen.common.vo.page.JsonPage;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author leon
 * @date 2021-12-20 16:12
 */
public interface AppBindService {
    /**
     * 更新产品绑定上线状态
     *
     * @param appCode 产品编码
     * @param isOn    产品
     * @return {@link  Boolean}    上线状态
     */
    Boolean updateIsOn(String appCode, Boolean isOn);

    /**
     * 产品绑定列表
     * @param request   产品绑定列表-request
     * @param page  分页信息
     * @return  {@link  AppBindListVoPage}  产品绑定列表-page
     */
    AppBindListVoPage listAppBind(AppBindListRequest request, JsonPage<T> page);
}
