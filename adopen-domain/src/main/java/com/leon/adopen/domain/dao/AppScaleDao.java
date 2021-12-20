package com.leon.adopen.domain.dao;

import com.leon.adopen.domain.entity.AppScale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author leon
 * @date 2021-12-13 16:52
 */
@Repository
public interface AppScaleDao extends JpaRepository<AppScale, Integer> {
}
