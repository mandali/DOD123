package com.omniwyse.dod.api;

import com.omniwyse.dod.model.ConsumerRegistresponse;
import com.omniwyse.dod.model.GetpromotionResponse;
import com.omniwyse.dod.model.Loginresponse;
import com.omniwyse.dod.model.OTPResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by omniwyse on 30-01-2017.
 * The Communicator class performs the call and contains the methods which create the Rest Adapter.
 */

public interface APIInterface {
    //This method is used for "POST"


    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("register")
    Call<Loginresponse> Login(
            @Field("user_id") String username

    );


    @Headers("Content-Type: application/json")
    @POST("consumerlogin")
    Call<Loginresponse> ComsumerLogin(@Body Loginbodyrequest body);

    @GET("getpromotions")
    Call<List<GetpromotionResponse>> getPromotions();

    @Headers("Content-Type: application/json")
    @POST("register")
    Call<ConsumerRegistresponse> ConsumerRegistration(@Body ConsumerRegisterbodyrequest body);

    @Headers("Content-Type: application/json")
    @POST("OTPvalidate")
    Call<OTPResponse> OTPValidate(@Body Otpbodyrequest body);

    @GET("brands")
    Call<GetBrandsresponse> getBrands();



}
