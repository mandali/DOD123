package com.omniwyse.dod.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by surya on 3/6/2017.
 */

public class BeaconData  {

    @SerializedName("beaconId")
  
    private String beaconId;
    @SerializedName("beaconName")
  
    private String beaconName;
    @SerializedName("merchantId")
  
    private String merchantId;
    @SerializedName("merchantName")
  
    private String merchantName;
    @SerializedName("locationId")
  
    private String locationId;
    @SerializedName("locationName")
  
    private String locationName;
    @SerializedName("aisleId")
  
    private String aisleId;
    @SerializedName("aisleName")
  
    private String aisleName;
    @SerializedName("promotionDtos")
  
    private List<BeaconPromotions> promotionDtos = null;

    public String getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(String beaconId) {
        this.beaconId = beaconId;
    }

    public String getBeaconName() {
        return beaconName;
    }

    public void setBeaconName(String beaconName) {
        this.beaconName = beaconName;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
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

    public String getAisleId() {
        return aisleId;
    }

    public void setAisleId(String aisleId) {
        this.aisleId = aisleId;
    }

    public String getAisleName() {
        return aisleName;
    }

    public void setAisleName(String aisleName) {
        this.aisleName = aisleName;
    }

    public List<BeaconPromotions> getPromotionDtos() {
        return promotionDtos;
    }

    public void setPromotionDtos(List<BeaconPromotions> promotionDtos) {
        this.promotionDtos = promotionDtos;
    }

}