package com.leon.adopen.admin.v2.app.vo;

import com.leon.adopen.admin.v2.app.base.BaseApp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 产品点击列表-vo
 *
 * @author leon
 * @date 2021-12-26 22:13
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppClickListVo extends BaseApp {
    private String cpName;
    private String channelCode;
    private Integer clickCount;
    private String clickDate;

    public AppClickListVo(Integer appId, String appCode, String appName, String spName, Integer limitDay, String cpName, String channelCode, Integer clickCount, String clickDate) {
        super(appId, appCode, appName, spName, limitDay);
        this.cpName = cpName;
        this.channelCode = channelCode;
        this.clickCount = clickCount;
        this.clickDate = clickDate;
    }
}
