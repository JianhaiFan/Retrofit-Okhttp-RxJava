package com.xiaofan.retrofit_okhttp_rxjava_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xiaofan.retrofit_okhttp_rxjava_demo.util.LogUtil;

/**
 * Created by fanjianhai on 2017/3/15.
 */
public class RetrofitRxJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_rxjava);
    }

    public void onClick(View view) {
        LogUtil.e("onClick...");
    }

}
