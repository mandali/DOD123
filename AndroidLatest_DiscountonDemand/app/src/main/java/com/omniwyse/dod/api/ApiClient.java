package com.omniwyse.dod.api;

/**
 * Created by Mukesh on 30-01-2017.
 * updated test comments
 */


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.omniwyse.dod.customUtils.AppConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Hellotet from Mukesh Srivastav

public class ApiClient {


    private static Retrofit retrofit = null;


    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
