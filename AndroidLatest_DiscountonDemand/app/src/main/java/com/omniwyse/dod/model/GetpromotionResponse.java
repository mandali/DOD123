package com.omniwyse.dod.model;

import android.graphics.Movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;


import java.util.HashMap;
import java.util.Map;

public class GetpromotionResponse {

    @SerializedName("id")
    private Integer id;

    @SerializedName("product_id")
    private String product_id;

    @SerializedName("description")
    private String description;

    @SerializedName("category_name")
    private String category_name;

    @SerializedName("product_image")
    private String product_image;

    @SerializedName("originalPrice")
    private String originalPrice;

    @SerializedName("discount")
    private String discount;

    @SerializedName("createddate")
    private String createddate;

    @SerializedName("startdate")
    private String startdate;

    @SerializedName("enddate")
    private String enddate;

    @SerializedName("location")
    private String location;

    @SerializedName("success")
    private String success;

    @SerializedName("message")
    private String message;

    @SerializedName("statusCode")
    private String statusCode;


    private List<GetpromotionResponse> results;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<GetpromotionResponse> getResults() {
        return results;
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getproduct_id() {
        return product_id;
    }

    public void setproduct_id(String product_id) {
        this.product_id = product_id;
    }


    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }


    public String getcategory_name() {
        return category_name;
    }

    public void setcategory_name(String category_name) {
        this.category_name = category_name;
    }


    public String getproduct_image() {
        return product_image;
    }

    public void setproduct_image(String product_image) {
        this.product_image = product_image;
    }


    public String getOrginalPrice() {
        return originalPrice;
    }

    public void setOrginalPrice(String orginalPrice) {
        this.originalPrice = orginalPrice;
    }

    public String getdiscount() {
        return discount;
    }

    public void setdiscount(String discount) {
        this.discount = discount;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }


    public String getlocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getsuccess() {
        return success;
    }

    public void setsuccess(String success) {
        this.success = success;
    }


    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
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