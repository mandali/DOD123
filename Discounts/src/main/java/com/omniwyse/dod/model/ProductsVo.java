package com.omniwyse.dod.model;

import java.io.Serializable;
import java.sql.Timestamp;



public class ProductsVo implements Serializable{
	
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private Long productId;		
		private String productDescription;		
		private String productImageLocation;		
		private Timestamp productCreatedDate;
		public Long getProductId() {
			return productId;
		}
		public void setProductId(Long productId) {
			this.productId = productId;
		}
		public String getProductDescription() {
			return productDescription;
		}
		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}
		public String getProductImageLocation() {
			return productImageLocation;
		}
		public void setProductImageLocation(String productImageLocation) {
			this.productImageLocation = productImageLocation;
		}
		public Timestamp getProductCreatedDate() {
			return productCreatedDate;
		}
		public void setProductCreatedDate(Timestamp productCreatedDate) {
			this.productCreatedDate = productCreatedDate;
		}
		
		

}
