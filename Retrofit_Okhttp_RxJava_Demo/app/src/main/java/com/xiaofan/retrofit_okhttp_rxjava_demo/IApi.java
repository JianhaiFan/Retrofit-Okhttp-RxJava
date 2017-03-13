package com.xiaofan.retrofit_okhttp_rxjava_demo;

import com.xiaofan.retrofit_okhttp_rxjava_demo.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by fanjianhai on 2017/3/12.
 */
public interface IApi {

//    @POST("add")//直接把对象通过ConverterFactory转化成对应的参数
//    Call<List<User>> addUser(@Body User user);

//    @POST
//    Call<User> addUser(@Body User user, @Field());

    @FormUrlEncoded
    @POST("sysCommon/control/restful/ajaxGetVerificationCode")
    Call<User> ajaxGetVerificationCode(@Field("partyClient") String partyClient,
                                       @Field("type") String type,
                                       @Field("userLoginId") String userLoginId);

    @GET("users/{groupId}")//动态路径get请求
    Call<List<User>> getUsers(@Path("userId") String userId);



}
