package com.omniwyse.dod.DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CategoryPromotion implements Serializable {

	private Long categoryId;
	private Long brandId;
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	
}
