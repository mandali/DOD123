package com.omniwyse.dod.api;

/**
 * Created by Mukesh on 30-01-2017.
 * updated test comments
 */


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Hellotet from Mukesh Srivastav

public class ApiClient {

    public static final String BASE_URL = " http://54.193.11.3:8080/Discounts/";
    private static Retrofit retrofit = null;


    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
