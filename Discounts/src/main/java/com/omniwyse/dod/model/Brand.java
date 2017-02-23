package com.omniwyse.dod.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "brand")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Brand implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "BRD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brandId;
	@Column(name ="BRD_NAME")
	private String brandName;	
	@Column(name ="BRD_RATING")
	private String brandRating;
	@Column(name ="BRD_IMAGE")
	private String brandImage;
	@Column(name ="BRD_DESC")
	private String brandDescription;	
	@Column(name = "BRD_CREATED")
	private Timestamp createdDate;
	
	public Brand(){
	}
	
	
	
	
	public Brand(Long brandId, String brandName, String brandRating, String brandImage, String brandDescription,
			Timestamp createdDate) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandRating = brandRating;
		this.brandImage = brandImage;
		this.brandDescription = brandDescription;
		this.createdDate = createdDate;
	}




	public Brand(Long brandId) {
		this.brandId = brandId;
	}




	public Long getBrandid() {
		return brandId;
	}
	public void setBrandid(Long brandid) {
		this.brandId = brandid;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandRating() {
		return brandRating;
	}
	public void setBrandRating(String brandRating) {
		this.brandRating = brandRating;
	}
	public String getBrandImage() {
		return brandImage;
	}
	public void setBrandImage(String brandImage) {
		this.brandImage = brandImage;
	}
	public String getBrandDescription() {
		return brandDescription;
	}
	public void setBrandDescription(String brandDescription) {
		this.brandDescription = brandDescription;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	


}
