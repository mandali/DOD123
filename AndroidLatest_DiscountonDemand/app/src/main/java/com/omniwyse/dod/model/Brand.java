package com.omniwyse.dod.model;


/**
 * Created by Mukesh checking aain on 06-03-2017.
 *
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Brand {

    @SerializedName("brandId")
    @Expose
    private String brandId;
    @SerializedName("brandName")
    @Expose
    private String brandName;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("brandRating")
    @Expose
    private String brandRating;
    @SerializedName("brandImage")
    @Expose
    private String brandImage;
    @SerializedName("brandDescription")
    @Expose
    private String brandDescription;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getBrandRating() {
        return brandRating;
    }

    public void setBrandRating(String brandRating) {
        this.brandRating = brandRating;
    }

    public String getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

