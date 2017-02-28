package com.omniwyse.dod.DTO;

public class CategoryVO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String categoryId;
	private String categoryName;
	private String createdDate;
	private String categoryImage;
	private String categoryRank;
	
	

	public CategoryVO(){
		
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

	public String getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}

	public String getCategoryRank() {
		return categoryRank;
	}

	public void setCategoryRank(String categoryRank) {
		this.categoryRank = categoryRank;
	}
	
	

}
