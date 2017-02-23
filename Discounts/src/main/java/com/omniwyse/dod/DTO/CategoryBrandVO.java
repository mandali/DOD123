package com.omniwyse.dod.DTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryBrandVO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String categoryId;
	private String categoryName;
	private String createdDate;
	private List<BrandVO> brands=new ArrayList<BrandVO>();
	
	public List<BrandVO> getBrands() {
		return brands;
	}

	public void setBrands(List<BrandVO> brands) {
		this.brands = brands;
	}

	public CategoryBrandVO(){
		
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
