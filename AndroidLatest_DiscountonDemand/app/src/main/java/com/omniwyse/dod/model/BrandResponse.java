package com.omniwyse.dod.model;

import java.util.HashMap;
import java.util.Map;

public class BrandResponse {

    private String brandId;
    private String brandName;
    private String created;
    private String brandRating;
    private String brandImage;
    private String brandDescription;

    // Getter and Setter model for recycler view items
    private String title;
    private int image;

    public BrandResponse(String title, int image) {

        this.title = title;

        this.image = image;
    }

    public String getTitle() {
        return title;
    }


    public int getImage() {
        return image;
    }

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
