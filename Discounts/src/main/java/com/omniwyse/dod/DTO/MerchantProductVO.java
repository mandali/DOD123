package com.omniwyse.dod.DTO;

public class MerchantProductVO implements java.io.Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private String productId;
		private String productDescription;
		private String productImage;
		private String createdDate;

		public MerchantProductVO() {
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

