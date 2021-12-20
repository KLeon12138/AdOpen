package com.leon.adopen.admin.v2.app.service;

/**
 * app限量-service
 *
 * @author leon
 * @date 2021-12-20 15:08
 */
public interface AppLimitService {
    /**
     * 更新产品限量静态变量值
     *
     * @param appCode 产品编码
     * @param limit   限量
     * @return {@link  Integer}    修改后限量
     */
    Integer updateLimit(String appCode, Integer limit);
}
