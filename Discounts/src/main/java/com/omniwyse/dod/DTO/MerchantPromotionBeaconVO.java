package com.omniwyse.dod.DTO;

public class MerchantPromotionBeaconVO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String merchantId;
	private String promotionId;
	private String beaconId;
	private String aisleId;

	
	public MerchantPromotionBeaconVO(){
		
	}


	public String getMerchantId() {
		return merchantId;
	}


	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}


	public String getPromotionId() {
		return promotionId;
	}


	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}


	public String getBeaconId() {
		return beaconId;
	}


	public void setBeaconId(String beaconId) {
		this.beaconId = beaconId;
	}


	public String getAisleId() {
		return aisleId;
	}


	public void setAisleId(String aisleId) {
		this.aisleId = aisleId;
	}
	
	
	
}
