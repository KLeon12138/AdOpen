package com.leon.adopen.domain.dao;

import com.leon.adopen.domain.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * app-dao
 *
 * @author leon
 * @date 2021-11-26 14:18
 */
@Repository
public interface AppDao extends JpaRepository<App, Integer> {
    /**
     * 根据产品编码校验重复性
     *
     * @param appCode 产品编码
     * @return {@link  Boolean}    是否存在
     */
    Boolean existsByAppCode(String appCode);

    /**
     * 根据产品编码查询产品
     *
     * @param appCode 产品编码
     * @return {@link  App}    产品属性
     */
    App findByAppCode(String appCode);
}
