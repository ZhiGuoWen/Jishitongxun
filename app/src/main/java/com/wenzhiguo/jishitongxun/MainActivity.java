package com.wenzhiguo.jishitongxun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.rong.imkit.RongIM;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test(View view) {
        if (RongIM.getInstance() != null) {
            RongIM.getInstance().startPrivateChat(this,"100","小姐");
        }
    }
}
