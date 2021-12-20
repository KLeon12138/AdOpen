package com.leon.adopen.domain.manager;

import com.leon.adopen.common.utils.StringUtils;
import com.leon.adopen.domain.dao.AppDao;
import com.leon.adopen.domain.entity.App;
import com.leon.adopen.domain.exception.enums.AdopenDbCode;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author leon
 * @date 2021-12-20 14:53
 */
@Service
public class AppManager {
    @Resource
    private AppDao appDao;

    /**
     * 根据产品编码查询产品日限
     *
     * @param appCode 产品编码
     * @return {@link  Integer}    产品日限
     * @throws AdopenDbException 产品空异常
     */
    public Integer limitForApp(String appCode) throws AdopenDbException {
        App app = appDao.findByAppCode(appCode);
        if (StringUtils.isEmpty(app)) {
            throw new AdopenDbException(AdopenDbCode.nullDataFailed, "不存在该产品,产品编码:" + appCode);
        }
        return app.getLimitDay();
    }
}
