package com.omniwyse.dod.DTO;

import java.io.Serializable;

public class IAliseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IAliseVO(){
	}
	
	private String merchantId;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
	
	
}
