package com.bwie.user.bean;

/**
 * Created by w h l on 2017/11/13.
 */

public class NewUserBean {
    private String msg;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public NewUserBean(String msg, String code) {

        this.msg = msg;
        this.code = code;
    }
}
