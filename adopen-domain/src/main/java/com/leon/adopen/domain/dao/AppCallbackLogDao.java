package com.leon.adopen.domain.dao;

import com.leon.adopen.domain.entity.AppCallbackLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author leon
 * @date 2021-12-13 16:51
 */
@Repository
public interface AppCallbackLogDao extends JpaRepository<AppCallbackLog, Integer> {
    Boolean existsByAdAppIdAndIdfa(String appid, String idfa);
}
