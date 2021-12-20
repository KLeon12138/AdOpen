package com.leon.adopen.admin.v2.app.vo;

import com.leon.adopen.admin.v2.app.base.BaseApp;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 产品-vo
 *
 * @author leon
 * @date 2021-12-16 11:50
 */
@Getter
@Setter
public class AppListVo extends BaseApp {
    public AppListVo(Integer appId, String appCode, String appName, Byte platform, Byte type, Integer spId, String spName, BigDecimal price, Integer limitDay, Byte urlType, String previewUrl, String onlineUrl, Byte backFormat, Byte book, String demand, Boolean isRemove, String remark) {
        super(appId, appCode, appName, platform, type, spId, spName, price, limitDay, urlType, previewUrl, onlineUrl, backFormat, book, demand, isRemove, remark);
    }
}
