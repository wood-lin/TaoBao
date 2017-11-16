package com.bwie.user.utils;

/**
 * Created by w h l on 2017/11/13.
 * 定义消息事件类
 */

public class MessageEvent {
    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
