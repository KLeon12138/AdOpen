package com.leon.adopen.dock.v2.app.rest;

import com.leon.adopen.common.constants.dock.ClickConstants;
import com.leon.adopen.common.constants.route.RouteConstants;
import com.leon.adopen.dock.v2.app.servicemark.ClickSzxService;
import com.leon.adopen.dock.v2.app.servicemark.ClickYdwxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author leon
 * @date 2021-12-24 11:30
 */
@RestController
@RequestMapping(RouteConstants.DOCK_PORT_CLICK)
@Validated
@Slf4j
public class ClickNewRest {
    @Resource
    private ClickYdwxService ydwxService;
    @Resource
    private ClickSzxService szxService;

    /**
     * 上报乐读文学
     *
     * @param appid   产品 id
     * @param idfa    idfa 标识
     * @param ip      设备 ip
     * @param channel 渠道号
     * @return {@link  String} 通用返回类
     * @throws Exception 通用异常
     */
    @GetMapping("/ydwx")
    public String clickYdwx(@RequestParam String appid, @RequestParam String idfa, @RequestParam String ip, @RequestParam String channel, @RequestParam String callback) throws Exception {
        ydwxService.click(appid, idfa, ip, channel, callback);
        return ClickConstants.DEFAULT_RESULT;
    }

    /**
     * 上报乐读文学
     *
     * @param appid   产品 id
     * @param idfa    idfa 标识
     * @param ip      设备 ip
     * @param channel 渠道号
     * @return {@link  String} 通用返回类
     * @throws Exception 通用异常
     */
    @GetMapping("/szx")
    public String clickSzx(@RequestParam String appid, @RequestParam String idfa, @RequestParam String ip, @RequestParam String channel, @RequestParam String callback) throws Exception {
        szxService.click(appid, idfa, ip, channel, callback);
        return ClickConstants.DEFAULT_RESULT;
    }
}
