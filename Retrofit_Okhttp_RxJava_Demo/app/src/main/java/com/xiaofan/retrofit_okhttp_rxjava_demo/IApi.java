package com.xiaofan.retrofit_okhttp_rxjava_demo;

import com.xiaofan.retrofit_okhttp_rxjava_demo.bean.ParamBean;
import com.xiaofan.retrofit_okhttp_rxjava_demo.bean.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by fanjianhai on 2017/3/12.
 */
public interface IApi {

    /**
     * Retrofit网络请求Service，@Path、@Query、@QueryMap...相关注解的解释
     * http://www.jianshu.com/p/7687365aa946
     */

    @FormUrlEncoded
    @POST("sysCommon/control/restful/ajaxGetVerificationCode")
    Call<User> ajaxGetVerificationCode(@Field("partyClient") String partyClient,
                                       @Field("type") String type,
                                       @Field("userLoginId") String userLoginId);

    @POST("sysCommon/control/restful/ajaxGetVerificationCode")
    Call<User> ajaxGetVerificationCode(@Body ParamBean paramBean);

    @FormUrlEncoded
    @POST("sysCommon/control/restful/ajaxGetVerificationCode")
    Call<User> ajaxGetVerificationCode(@FieldMap Map<String,String> fieldMap);





}
