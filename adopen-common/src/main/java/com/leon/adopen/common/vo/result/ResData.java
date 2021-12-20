package com.leon.adopen.common.vo.result;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leon
 * @date 2021-12-15 14:59
 */
public class ResData implements ResResult {
    private int code;
    private final String msg;
    private Object data;
    public static ResData ok() {
        return new ResData(ResCode.OK);
    }

    public static ResData build(ResCode code) {
        return new ResData(code);
    }

    public static ResData build(ResCode code, String msg) {
        return new ResData(code.getCode(), msg);
    }

    public ResData setData(Object data) {
        this.data = data;
        return this;
    }

    public ResData putData(String key, Object value) {
        if (this.data == null || !(this.data instanceof Map)) {
            this.data = new HashMap();
        }

        ((Map)this.data).put(key, value);
        return this;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public Object getData() {
        return this.data;
    }

    @Override
    public Object getData(String key) {
        return this.data == null ? null : ((Map)this.data).get(key);
    }

    @Override
    public Object removeData(String key) {
        if (key == null) {
            Object r = this.data;
            this.data = null;
            return r;
        } else {
            return this.data == null ? null : ((Map)this.data).remove(key);
        }
    }

    public ResData(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResData(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = this.data;
    }

    private ResData(ResCode resCode) {
        this.code = resCode.getCode();
        this.msg = resCode.getMsg();
    }
}
