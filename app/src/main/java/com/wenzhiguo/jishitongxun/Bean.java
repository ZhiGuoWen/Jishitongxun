package com.wenzhiguo.jishitongxun;

/**
 * Created by dell on 2017/5/23.
 * action :
 */

public class Bean {
    private String UserID;
    private String UserName;
    private String UserUri;

    public Bean(String userID,String userName,  String userUri) {
        UserName = userName;
        UserID = userID;
        UserUri = userUri;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserUri() {
        return UserUri;
    }

    public void setUserUri(String userUri) {
        UserUri = userUri;
    }
}
