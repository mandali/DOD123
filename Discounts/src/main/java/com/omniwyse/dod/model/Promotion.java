package com.omniwyse.dod.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;



@Entity
@Table(name = "promotions")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Promotion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "PRMS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;			
	@Column(name = "P_ID")	
	private String product_id;	
	@Column(name = "PRMS_DESC")	
	private String description;	
	@Column(name = "Merchant_ID")	
	private Integer merchatid;	
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
	@OneToOne
	@JoinColumn(name = "CAT_ID")
	private Category catid;	
	@ManyToOne
	@JoinColumn(name = "BRD_ID")	
	private Brand brandId;
	@Column(name="PRMS_DISC_TXT")
	private String discountText;
	public Promotion(){
	}	


	
	public Category getCatid() {
		return catid;
	}



	public Promotion(Integer id, String product_id, String description, Integer merchatid, String product_image,
			String originalPrice, String discount, Date createddate, Date startdate, Date enddate, String location,
			Category catid, Brand brandId, String discountText) {
		this.id = id;
		this.product_id = product_id;
		this.description = description;
		this.merchatid = merchatid;
		this.product_image = product_image;
		this.originalPrice = originalPrice;
		this.discount = discount;
		this.createddate = createddate;
		this.startdate = startdate;
		this.enddate = enddate;
		this.location = location;
		this.catid = catid;
		this.brandId = brandId;
		this.discountText = discountText;
	}







	public void setCatid(Category catid) {
		this.catid = catid;
	}
	public Brand getBrandId() {
		return brandId;
	}
	public void setBrandId(Brand brandId) {
		this.brandId = brandId;
	}
	public Integer getMerchatid() {
		return merchatid;
	}
	public void setMerchatid(Integer merchatid) {
		this.merchatid = merchatid;
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
	public String getDiscountText() {
		return discountText;
	}
	public void setDiscountText(String discountText) {
		this.discountText = discountText;
	}	
	

}
