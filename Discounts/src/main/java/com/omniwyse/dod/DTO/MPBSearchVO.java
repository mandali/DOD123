package com.omniwyse.dod.DTO;

import java.util.ArrayList;
import java.util.List;

public class MPBSearchVO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MPBSearchVO(){
		
	}
	
	private String beaconId;
	private String beaconName;
	private String merchantId;
	private String merchantName;
	private String locationId;
	private String locationName;
	private String aisleId;
	private String aisleName;
	private List<PromotionDto> promotionDtos=new ArrayList<PromotionDto>();

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
	public List<PromotionDto> getPromotionDtos() {
		return promotionDtos;
	}
	public void setPromotionDtos(List<PromotionDto> promotionDtos) {
		this.promotionDtos = promotionDtos;
	}
	
	
	

}
