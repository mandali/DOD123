package com.omniwyse.dod.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by surya on 3/6/2017.
 */

public class BeaconPromotions {

    @SerializedName("id")
    private int id;
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
    private double createddate;
    @SerializedName("startdate")
    private double startdate;
    @SerializedName("enddate")
    private double enddate;
    @SerializedName("location")
    private String location;
    @SerializedName("merchatId")
    private int merchatId;
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
    private int catid;
    @SerializedName("brandId")
    private int brandId;
    @SerializedName("discountText")
    
    private String discountText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getCreateddate() {
        return createddate;
    }

    public void setCreateddate(double createddate) {
        this.createddate = createddate;
    }

    public double getStartdate() {
        return startdate;
    }

    public void setStartdate(double startdate) {
        this.startdate = startdate;
    }

    public double getEnddate() {
        return enddate;
    }

    public void setEnddate(double enddate) {
        this.enddate = enddate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMerchatId() {
        return merchatId;
    }

    public void setMerchatId(int merchatId) {
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

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getDiscountText() {
        return discountText;
    }

    public void setDiscountText(String discountText) {
        this.discountText = discountText;
    }

}