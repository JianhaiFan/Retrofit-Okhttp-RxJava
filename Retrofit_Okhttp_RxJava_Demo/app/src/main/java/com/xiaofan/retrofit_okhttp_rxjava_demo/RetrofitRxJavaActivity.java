package com.xiaofan.retrofit_okhttp_rxjava_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.xiaofan.retrofit_okhttp_rxjava_demo.constant.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fanjianhai on 2017/3/15.
 * http://blog.csdn.net/mlq8087/article/details/51891005
 */
public class RetrofitRxJavaActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private OkHttpClient mOkHttpClient;

    private ImageView iv_icon;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_rxjava);

        // 初始OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)//设置超时时间
                .readTimeout(10, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(10, TimeUnit.SECONDS);//设置写入超时时间
        mOkHttpClient = builder.build();
        // 初始化Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(mOkHttpClient)
                .build();

        iv_icon = (ImageView) findViewById(R.id.iv_icon);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    public void onClick(View view) {

    }


}
