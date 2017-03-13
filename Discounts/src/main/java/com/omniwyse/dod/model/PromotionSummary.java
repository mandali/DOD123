package com.omniwyse.dod.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@Entity
@Table(name = "promotions_summary")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PromotionSummary implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "SUMMARY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer promotionSummaryId;	
	@OneToOne
	@JoinColumn(name="CAT_ID")
	private Category categoryID;
	@Column(name = "PRM_COUNT")	
	private Integer count;	
	@Column(name = "MIN_DISCOUNT")	
	private Integer minDiscount;	
	@Column(name = "MAX_DISCOUNT")	
	private Integer maxDiscount;	
	@OneToOne
	@JoinColumn(name="BRD_ID")
	private Brand brandId;	
	@Column(name = "CREATED_DATE")
	private Timestamp createddate;
	
	
	public PromotionSummary() {
	}


	public PromotionSummary(Integer promotionSummaryId, Category categoryID, Integer count, Integer minDiscount,
			Integer maxDiscount, Brand brandId, Timestamp createddate) {
		this.promotionSummaryId = promotionSummaryId;
		this.categoryID = categoryID;
		this.count = count;
		this.minDiscount = minDiscount;
		this.maxDiscount = maxDiscount;
		this.brandId = brandId;
		this.createddate = createddate;
	}


	public Integer getPromotionSummaryId() {
		return promotionSummaryId;
	}


	public void setPromotionSummaryId(Integer promotionSummaryId) {
		this.promotionSummaryId = promotionSummaryId;
	}


	public Category getCategoryID() {
		return categoryID;
	}


	public void setCategoryID(Category categoryID) {
		this.categoryID = categoryID;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public Integer getMinDiscount() {
		return minDiscount;
	}


	public void setMinDiscount(Integer minDiscount) {
		this.minDiscount = minDiscount;
	}


	public Integer getMaxDiscount() {
		return maxDiscount;
	}


	public void setMaxDiscount(Integer maxDiscount) {
		this.maxDiscount = maxDiscount;
	}


	public Brand getBrandId() {
		return brandId;
	}


	public void setBrandId(Brand brandId) {
		this.brandId = brandId;
	}


	public Timestamp getCreateddate() {
		return createddate;
	}


	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}
	
	
	
	
	
	
	
	
	
	

	

}
