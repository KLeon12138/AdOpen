package com.leon.adopen.domain.dao;

import com.leon.adopen.domain.entity.Sp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author leon
 * @date 2021-12-15 17:45
 */
@Repository
public interface SpDao extends JpaRepository<Sp, Integer> {
    /**
     * 根据上游名称查重
     *
     * @param spName 上游名称
     * @return {@link   Boolean}   是否存在
     */
    Boolean existsByName(String spName);
}
