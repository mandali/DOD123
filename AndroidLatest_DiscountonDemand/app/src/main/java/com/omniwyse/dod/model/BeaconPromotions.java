package com.omniwyse.dod.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by surya on 3/6/2017.
 */

public class BeaconPromotions {

    @SerializedName("id")
    private Integer id;
    @SerializedName("product_id")
    
    private String productId;
    @SerializedName("description")
    
    private String description;
    @SerializedName("product_image")
    
    private String productImage;
    @SerializedName("originalPrice")
    
    private String originalPrice;
    @SerializedName("discount")
    
    private String discount;
    @SerializedName("createddate")
    
    private long createddate;
    @SerializedName("startdate")
    
    private long startdate;
    @SerializedName("enddate")
    
    private long enddate;
    @SerializedName("merchatId")
    
    private Integer merchatId;
    @SerializedName("brandName")
    
    private String brandName;
    @SerializedName("brandRating")
    
    private String brandRating;
    @SerializedName("brandImage")
    
    private String brandImage;
    @SerializedName("brandDescription")
    
    private String brandDescription;
    @SerializedName("categoryName")
    
    private String categoryName;
    @SerializedName("catid")
    
    private Integer catid;
    @SerializedName("brandId")
    
    private Integer brandId;
    @SerializedName("discountText")
    
    private String discountText;
    @SerializedName("locationId")
    
    private String locationId;
    @SerializedName("locationName")
    
    private String locationName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public long getCreateddate() {
        return createddate;
    }

    public void setCreateddate(long createddate) {
        this.createddate = createddate;
    }

    public long getStartdate() {
        return startdate;
    }

    public void setStartdate(long startdate) {
        this.startdate = startdate;
    }

    public long getEnddate() {
        return enddate;
    }

    public void setEnddate(long enddate) {
        this.enddate = enddate;
    }

    public Integer getMerchatId() {
        return merchatId;
    }

    public void setMerchatId(Integer merchatId) {
        this.merchatId = merchatId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getDiscountText() {
        return discountText;
    }

    public void setDiscountText(String discountText) {
        this.discountText = discountText;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

}
