package com.leon.adopen.domain.dao;

import com.leon.adopen.domain.entity.AppClick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 产品点击-dao
 *
 * @author leon
 * @date 2021-12-22 15:34
 */
@Repository
public interface AppClickDao extends JpaRepository<AppClick, Integer> {
    /**
     * 根据渠道码及点击日期查重
     *
     * @param channelCode 渠道码
     * @param clickDate   点击日期
     * @return {@link  Boolean}    是否存在
     */
    Boolean existsByChannelCodeAndClickDate(String channelCode, String clickDate);

    /**
     * 根据渠道码和点击日期查询
     *
     * @param channelCode 渠道码
     * @param clickDate   点击日期
     * @return {@link  AppClick}    点击记录
     */
    AppClick findByChannelCodeAndClickDate(String channelCode, String clickDate);
}
