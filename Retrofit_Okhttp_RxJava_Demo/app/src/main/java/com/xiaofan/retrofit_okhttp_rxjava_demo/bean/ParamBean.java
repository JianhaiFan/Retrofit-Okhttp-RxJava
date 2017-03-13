
package com.xiaofan.retrofit_okhttp_rxjava_demo.bean;

/**
 * Created by fanjianhai on 2017/3/13.
 */
public class ParamBean {

    private String partyClient;

    private String type;

    private String userLoginId;

    public ParamBean() {}

    public ParamBean(String partyClient, String type, String userLoginId) {
        this.partyClient = partyClient;
        this.type = type;
        this.userLoginId = userLoginId;
    }

    public String getPartyClient() {
        return partyClient;
    }

    public void setPartyClient(String partyClient) {
        this.partyClient = partyClient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    @Override
    public String toString() {
        return "ParamBean{" +
                "partyClient='" + partyClient + '\'' +
                ", type='" + type + '\'' +
                ", userLoginId='" + userLoginId + '\'' +
                '}';
    }
}
