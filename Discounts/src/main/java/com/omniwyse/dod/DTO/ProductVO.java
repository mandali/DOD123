package com.omniwyse.dod.DTO;

import java.util.ArrayList;
import java.util.List;

public class ProductVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductVO() {
	}

	private String merchantId;
	private List<MerchantProductVO> merchantProducts=new ArrayList<MerchantProductVO>();

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public List<MerchantProductVO> getMerchantProducts() {
		return merchantProducts;
	}

	public void setMerchantProducts(List<MerchantProductVO> merchantProducts) {
		this.merchantProducts = merchantProducts;
	}
	

	
	

	

	

}
