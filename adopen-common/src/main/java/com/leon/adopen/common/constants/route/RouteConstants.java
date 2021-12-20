package com.leon.adopen.common.constants.route;

/**
 * @author leon
 * @date 2021-12-15 14:36
 */
public class RouteConstants {
    private static final String PROJECT_ADMIN = "/admin";
    private static final String PROJECT_DOCK = "/dock";
    private static final String VERSION_V2 = "/v2";

    public static final String DOCK_PORT_CLICK = PROJECT_DOCK + VERSION_V2 + "/click";

    public static final String ADMIN_PORT_APP = PROJECT_ADMIN + VERSION_V2 + "/app";
    public static final String ADMIN_PORT_APP_BIND = PROJECT_ADMIN + VERSION_V2 + "/app/bind";
    public static final String ADMIN_PORT_SP = PROJECT_ADMIN + VERSION_V2 + "/sp";
    public static final String ADMIN_PORT_CP = PROJECT_ADMIN + VERSION_V2 + "/cp";
    public static final String ADMIN_PORT_APP_LIMIT = PROJECT_ADMIN + VERSION_V2 + "/app/limit";
}
