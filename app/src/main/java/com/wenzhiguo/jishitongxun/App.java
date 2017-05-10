package com.wenzhiguo.jishitongxun;

import android.app.Application;
import android.util.Log;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 * Created by dell on 2017/5/2.
 * action :
 */

public class App extends Application {

    @Override
    public void onCreate() {
        //初始化融云
        RongIM.init(this);
        String Token = "gdHRk0Zp2TntszhAKOy32Vq98lPtxfqb2fo8A7bwU5b3AyG4/qZ8atyX5QA7WP2Xo2u/Ht0Gm0qT/JfJ6QzEag==";
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
