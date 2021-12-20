package com.leon.adopen.domain.dao;

import com.leon.adopen.domain.entity.AppBind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品绑定-dao
 *
 * @author leon
 * @date 2021-12-20 15:59
 */
@Repository
public interface AppBindDao extends JpaRepository<AppBind, Integer> {
    /**
     * 查询全部产品绑定关系
     *
     * @param isDel 删除状态
     * @return {@link  List<AppBind>}  产品关系集合
     */
    List<AppBind> findAllByIsdel(Boolean isDel);

    /**
     * 根据产品上量状态查询
     *
     * @param isOn 上量状态
     * @return {@link  List<AppBind>}  产品关系集合
     */
    List<AppBind> findAllByIsOnStatus(Boolean isOn);

    /**
     * 更新产品绑定上线状态
     *
     * @param channelCode 产品编码
     * @param isOn        上线状态
     */
    @Modifying
    @Query("update AppBind ab set ab.isOnStatus =:isOn where ab.channelCode=:channelCode")
    void updateAppBindStatusByChannelCode(@Param(value = "channelCode") String channelCode, @Param(value = "isOn") Boolean isOn);
}
