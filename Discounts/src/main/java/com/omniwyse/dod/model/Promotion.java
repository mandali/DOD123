package com.omni.dod.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;



@Entity
@Table(name = "promotions")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Promotion {
	
	@Id
	@Column(name = "PRMS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;			
	@Column(name = "P_ID")	
	private String product_id;
	@Column(name = "PRMS_DESC")
	private String description;	
	@Column(name = "category_name")
	private String category_name;
	@Column(name = "product_image")
	private String product_image;	
	@Column(name = "original_price")
	private String originalPrice;
	@Column(name = "DISCOUNT")
	private String discount;
	@Column(name = "CRETATED_DATE")
	private Date createddate;
	@Column(name = "START_DATE")
	private Date startdate;	
	@Column(name = "END_DATE")
	private Date enddate;	
	@Column(name = "location")
	private String location;
	
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOriginalPrice() { 
		return originalPrice;
	}
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDiscount() {
		return discount;
	}
	
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}	

}
