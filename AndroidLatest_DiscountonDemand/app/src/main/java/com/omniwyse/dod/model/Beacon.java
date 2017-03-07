package com.omniwyse.dod.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by surya on 3/6/2017.
 */

public class Beacon {

    @SerializedName("success")
    private boolean success;
    @SerializedName("message")
    private String message;
    @SerializedName("statusCode")
    private int statusCode;
    @SerializedName("data")
    private List<BeaconData> data = null;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<BeaconData> getData() {
        return data;
    }

    public void setData(List<BeaconData> data) {
        this.data = data;
    }

}