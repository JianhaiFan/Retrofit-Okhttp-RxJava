
package com.xiaofan.retrofit_okhttp_rxjava_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xiaofan.retrofit_okhttp_rxjava_demo.bean.User;
import com.xiaofan.retrofit_okhttp_rxjava_demo.constant.Constant;
import com.xiaofan.retrofit_okhttp_rxjava_demo.util.LogUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private OkHttpClient mOkHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //http://192.168.1.24:9090/sysCommon/control/restful/ajaxGetVerificationCode
//        0 = {HashMap$HashMapEntry@830049680328} "partyClient" -> "appTypeEnum_0"
//        1 = {HashMap$HashMapEntry@830049680216} "type" -> "5006"
//        2 = {HashMap$HashMapEntry@830049680184} "userLoginId" -> "83112345678"
//        {"status":"2","msg":"该手机号已被注册"}

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
                .client(mOkHttpClient)
                .build();

    }

    public void onClick(View view) {

        IApi iApi = retrofit.create(IApi.class);

//        Call<User> call = iApi.ajaxGetVerificationCode("appTypeEnum_0","5006","83133333333");

//        ParamBean paramBean = new ParamBean("appTypeEnum_0","5006","83133333333");
//        Call<User> call = iApi.ajaxGetVerificationCode(paramBean);

        Map<String,String> params = new HashMap<String,String>();
        params.put("partyClient","appTypeEnum_0");
        params.put("type","5006");
        params.put("userLoginId","83112345678");

        Call<User> call = iApi.ajaxGetVerificationCode(params);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                LogUtil.e("user status: " + user.getStatus());
                LogUtil.e("user msg: " + user.getMsg());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                LogUtil.e("onFailure: " + "t: " + t.getMessage());
            }
        });

    }



}
