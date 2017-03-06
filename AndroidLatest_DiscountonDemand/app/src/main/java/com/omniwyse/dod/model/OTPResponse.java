package com.omniwyse.dod.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Mukesh checking aain on 2/22/2017.
 */

public class OTPResponse {

    @SerializedName("success")
    private String success;


    @SerializedName("message")
    private String message;

    @SerializedName("statusCode")
    private String statusCode;


    public String getsuccess() {
        return success;
    }

    public void setsuccess(String otp) {
        this.success = success;
    }


    public String getmessage() {
        return message;
    }

    public void setmessage(String otp) {
        this.message = message;
    }

    public String getstatusCode() {
        return statusCode;
    }

    public void setstatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

}


