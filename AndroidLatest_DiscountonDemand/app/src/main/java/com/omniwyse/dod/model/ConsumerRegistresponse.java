package com.omniwyse.dod.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by omniwyse on 01-02-2017.
 */

public class ConsumerRegistresponse {

    @SerializedName("id")
    private Integer id;
    @SerializedName("emailId")
    private String emailId;
    @SerializedName("phoneNo")
    private String phoneNo;
    @SerializedName("city")
    private String city;
    @SerializedName("age")
    private String age;
    @SerializedName("password")
    private String password;
    @SerializedName("confirmpassword")
    private String confirmpassword;
    @SerializedName("createddate")
    private Integer createddate;

    @SerializedName("otp")
    private String otp;

    @SerializedName("message")
    private String message;

    @SerializedName("statusCode")
    private String statusCode;

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getOtp() {
        return otp;
    }

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public Integer getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Integer createddate) {
        this.createddate = createddate;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
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

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
