package com.omniwyse.dod.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Loginresponse {

    @SerializedName("otpType")
    private String otpType;
    @SerializedName("otp")
    private String otp;

    @SerializedName("message")
    private String message;

    @SerializedName("statusCode")
    private String statusCode;


    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getOtpType() {
        return otpType;
    }

    public void setOtpType(String otpType) {
        this.otpType = otpType;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
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


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}