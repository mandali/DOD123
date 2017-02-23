package com.omniwyse.dod.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@Entity
@Table(name = "promotionsummery")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Promotionsummery implements Serializable{
	
	@Id
	@Column(name = "SUMMERY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long promotionSummeryId;	
	@Column(name = "IMAGE")	
	private String image;	
	@Column(name = "CATEGORY_ID")	
	private String categoryID;
	@Column(name = "CATEGORY_NAME")	
	private String categoryName;	
	@Column(name = "COUNT")	
	private String count;	
	@Column(name = "MIN_DISCOUNT")	
	private String minDiscount;	
	@Column(name = "MAX_DISCOUNT")	
	private String maxDiscount;	
	@Column(name = "BRAND_ID")	
	private String brandId;	
	@Column(name = "CREATED_CREATED")
	private Date createddate;
	public Long getPromotionSummeryId() {
		return promotionSummeryId;
	}
	public void setPromotionSummeryId(Long promotionSummeryId) {
		this.promotionSummeryId = promotionSummeryId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getMinDiscount() {
		return minDiscount;
	}
	public void setMinDiscount(String minDiscount) {
		this.minDiscount = minDiscount;
	}
	public String getMaxDiscount() {
		return maxDiscount;
	}
	public void setMaxDiscount(String maxDiscount) {
		this.maxDiscount = maxDiscount;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	
	

}
