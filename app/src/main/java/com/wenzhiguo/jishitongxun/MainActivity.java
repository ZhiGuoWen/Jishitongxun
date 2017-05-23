package com.wenzhiguo.jishitongxun;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.UserInfo;

public class MainActivity extends AppCompatActivity implements RongIM.UserInfoProvider {

    private ArrayList<Bean> mBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建集合,想结合添加数据信息
        mBean = new ArrayList<>();
        mBean.add(new Bean("987","t","https://img.ivrfans.cn/thumb/m/allimg/170507/1-1F50G64350,c_fill,h_360,w_240.jpg"));
        mBean.add(new Bean("333","w","https://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&word=%E7%BE%8E%E5%A5%B3%20%E5%AE%B3%E7%BE%9E&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&cs=3933460982,2855720533&os=4052881337,3303389887&simid=3057193165,3596332642&pn=1&rn=1&di=132836300300&ln=1966&fr=&fmq=1389861203899_R&fm=&ic=0&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&hs=2&oriquery=%E7%BE%8E%E5%A5%B3%E5%9B%BE&objurl=http%3A%2F%2Fk.zol-img.com.cn%2Fdcbbs%2F15721%2Fa15720807_0500.jpg&rpstart=0&rpnum=0&adpicid=0"));

        //参数1 userInfoProvider 用户信息提供者
        // 参数2 isCacheUserInfo 设置IMKit是否缓存用户信息,true就是缓存
        RongIM.setUserInfoProvider(this,true);
    }

    public void test(View view) {
        if (RongIM.getInstance() != null) {
            RongIM.getInstance().startPrivateChat(this,"333","w");
        }
    }

    public void refresh(View view) {
        //刷新请求发送过来的消息的图片
        RongIM.getInstance().refreshUserInfoCache(new UserInfo("333","w",Uri.parse("https://img.ivrfans.cn/thumb/m/allimg/170507/1-1F50G64350,c_fill,h_360,w_240.jpg")));
    }


    @Override
    public UserInfo getUserInfo(String s) {
        //判断是否创建过此ID用户
        for (Bean i:mBean) {
            if (i.getUserID().equals(s)){
                return new UserInfo(i.getUserID(),i.getUserName(), Uri.parse(i.getUserUri()));
            }
        }
        return null;
    }
}
