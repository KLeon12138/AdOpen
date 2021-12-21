package com.leon.adopen.admin.v2.app.vo;

import com.leon.adopen.admin.v2.app.base.BaseAppBind;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 产品绑定列表-vo
 *
 * @author leon
 * @date 2021-12-21 00:27
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppBindListVo extends BaseAppBind {
    public AppBindListVo(Integer appId, String appCode, String appName, Byte platform, Byte type, Integer spId, String spName, BigDecimal price, Integer limitDay, Byte urlType, String previewUrl, String onlineUrl, Byte backFormat, Byte book, String demand, String remark, Integer cpId, String cpName, String channelCode, BigDecimal channelPrice, String channelOnlineUrl, Boolean isOnStatus) {
        super(appId, appCode, appName, platform, type, spId, spName, price, limitDay, urlType, previewUrl, onlineUrl, backFormat, book, demand, remark, cpId, cpName, channelCode, channelPrice, channelOnlineUrl, isOnStatus);
    }
}
