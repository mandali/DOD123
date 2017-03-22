package com.omniwyse.dod.DTO;

import java.io.Serializable;
import java.util.Date;

import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.Product;

public class CreatePromotionVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private String product_id;
	private String description;
	private String merchatid;
	private String product_image;
	private String originalPrice;
	private String discount;
	private String locationId;
	private Date createddate;
	private Date startdate;	
	private Date enddate;
	private String catid;
	private String brandId;
	private String discountText;
	private String pId;
	private Product productId;
	
	private MerchantProfile merchantProfile;
	
	
	
	
	public CreatePromotionVo(){
		
	}
	
	
	
	public String getDiscountText() {
		return discountText;
	}
	public void setDiscountText(String discountText) {
		this.discountText = discountText;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public String getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
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
	



	public String getLocationId() {
		return locationId;
	}



	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}



	public Product getProductId() {
		return productId;
	}



	public void setProductId(Product productId) {
		this.productId = productId;
	}



	public MerchantProfile getMerchantProfile() {
		return merchantProfile;
	}



	public void setMerchantProfile(MerchantProfile merchantProfile) {
		this.merchantProfile = merchantProfile;
	}



	public String getMerchatid() {
		return merchatid;
	}



	public void setMerchatid(String merchatid) {
		this.merchatid = merchatid;
	}



	public String getCatid() {
		return catid;
	}



	public void setCatid(String catid) {
		this.catid = catid;
	}



	public String getBrandId() {
		return brandId;
	}



	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}



	public String getpId() {
		return pId;
	}



	public void setpId(String pId) {
		this.pId = pId;
	}




}
