package com.xiaofan.retrofit_okhttp_rxjava_demo.bean;

/**
 * Created by fanjianhai on 2017/3/12.
 */
public class User {

    private String status;

    private String msg;

    public User() {}

    public User(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "User{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
