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
	private List<MerchantProduct> merchantProducts=new ArrayList<MerchantProduct>();

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
	public List<MerchantProduct> getMerchantProducts() {
		return merchantProducts;
	}

	public void setMerchantProducts(List<MerchantProduct> merchantProducts) {
		this.merchantProducts = merchantProducts;
	}
	
	

	public class MerchantProduct {

		private String productId;
		private String productDescription;
		private String productImage;
		private String createdDate;

		public MerchantProduct() {
		}

		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public String getProductDescription() {
			return productDescription;
		}

		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}

		public String getProductImage() {
			return productImage;
		}

		public void setProductImage(String productImage) {
			this.productImage = productImage;
		}

		public String getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
	}



	

}
