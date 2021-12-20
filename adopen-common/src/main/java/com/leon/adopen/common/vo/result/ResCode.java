package com.leon.adopen.common.vo.result;

/**
 * @author leon
 * @date 2021-12-15 14:59
 */
public enum ResCode implements ResResult {
    /**
     * 操作成功
     */
    OK(200, "操作成功"),
    WAIT(0, "请稍后再试"),
    ERROR(-1, "请求失败,请稍后再试"),
    TOKEN_ERROR(1001, "登录超时请重新登录"),
    CODE_ERROR(1002, "验证码错误"),
    PASSWORD_ERROR(1003, "账号或密码错误"),
    USER_UN_EXSITS(1004, "用户不存在"),
    USER_NAME_EXSITS(1005, "用户名已存在"),
    MOBILE_REGISTERED(1006, "手机号已注册"),
    USER_FROZEN(1007, "用户已冻结"),
    USER_UN_ACTIVE(1008, "用户未激活"),
    PARAM_VERIFY_FAILED(2001, "参数校验错误"),
    ACCOUNT_UN_EXSITS(1010, "账户不存在"),
    MAINTAINING(4002, "系统维护中，请稍后再试");

    private int code;
    private String msg;

    private ResCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResData setData(Object data) {
        return ResData.ok().setData(data);
    }

    public ResData putData(String key, Object value) {
        return ResData.ok().putData(key, value);
    }

    public ResData msg(String msg) {
        return ResData.build(this, msg);
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public Object getData(String key) {
        return null;
    }

    @Override
    public Object removeData(String key) {
        return null;
    }

    public String getMsg() {
        return this.msg;
    }
}
