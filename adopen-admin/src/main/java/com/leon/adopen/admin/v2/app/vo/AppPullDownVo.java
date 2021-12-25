package com.leon.adopen.admin.v2.app.vo;

import com.leon.adopen.admin.v2.app.base.BaseApp;
import lombok.Getter;
import lombok.Setter;

/**
 * @author leon
 * @date 2021-12-25 23:17
 */
@Getter
@Setter
public class AppPullDownVo extends BaseApp {
    public AppPullDownVo(Integer appId, String appName) {
        super(appId, appName);
    }
}
