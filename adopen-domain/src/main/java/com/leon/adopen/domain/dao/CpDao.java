package com.leon.adopen.domain.dao;

import com.leon.adopen.domain.entity.Cp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author leon
 * @date 2021-12-15 17:44
 */
@Repository
public interface CpDao extends JpaRepository<Cp, Integer> {
    /**
     * 根据渠道名称查重
     *
     * @param cpName 渠道名称
     * @return {@link   Boolean}   是否存在
     */
    Boolean existsByName(String cpName);
}
