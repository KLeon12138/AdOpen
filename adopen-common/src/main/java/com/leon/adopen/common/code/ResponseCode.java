package com.leon.adopen.common.code;

import com.leon.adopen.common.exception.code.ExCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leon
 * @date 2021-11-29 16:59
 */
@Getter
public class ResponseCode {
    public static Object ok() {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", 0);
        obj.put("errmsg", "成功");
        return obj;
    }

    public static Object ok(Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", 0);
        obj.put("errmsg", "成功");
        obj.put("data", data);
        return obj;
    }

    public static Object ok(String errmsg, Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", 0);
        obj.put("errmsg", errmsg);
        obj.put("data", data);
        return obj;
    }

    public static Object defined(int errno, String errmsg, Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", errno);
        obj.put("errmsg", errmsg);
        obj.put("data", data);
        return obj;
    }

    public static Object fail() {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", ExCode.fail.getErrno());
        obj.put("errmsg", "错误");
        return obj;
    }

    public static Object fail(int errno, String errmsg) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", errno);
        obj.put("errmsg", errmsg);
        return obj;
    }

    public static Object fail(ExCode exCode) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", exCode.getErrno());
        obj.put("errmsg", exCode.getErrmsg());
        return obj;
    }

    public static Object fail(ExCode exCode, String errmsg) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", exCode.getErrno());
        obj.put("errmsg", errmsg);
        return obj;
    }

    public static Object badArgument(String errmsg) {
        return fail(ExCode.badArgument, errmsg);
    }

    public static Object badArgument() {
        return fail(ExCode.badArgument);
    }

    public static Object badArgumentValue() {
        return fail(ExCode.badArgumentValue);
    }

    public static Object updatedDateExpired() {
        return fail(ExCode.updatedDateExpired);
    }

    public static Object updatedDataFailed() {
        return fail(ExCode.updatedDataFailed);
    }

    public static Object addDataFailed() {
        return fail(ExCode.addDataFailed);
    }

    public static Object delDataFailed() {
        return fail(ExCode.delDataFailed);
    }

    public static Object serious() {
        return fail(ExCode.serious);
    }
}
