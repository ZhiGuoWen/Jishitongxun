package com.wenzhiguo.jishitongxun;

import android.app.Application;
import android.util.Log;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 * Created by dell on 2017/5/2.
 * action :初始化融云服务
 */

public class App extends Application {

    @Override
    public void onCreate() {
        //初始化融云
        RongIM.init(this);
        String Token = "uZgHdwvjUsXokprk1DNu11q98lPtxfqb2fo8A7bwU5Z1EsGp+VWM6hPhnNoMptgWRVUPJBx55YeT/JfJ6QzEag==";
        //建立与服务器连接
        RongIM.connect(Token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                //实效状态处理,重新获取token
            }

            @Override
            public void onSuccess(String s) {
                Log.d("zzz",s);
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.d("zzz",errorCode.toString());
            }
        });
        super.onCreate();
    }
}
