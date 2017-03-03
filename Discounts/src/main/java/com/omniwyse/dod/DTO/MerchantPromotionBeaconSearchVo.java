package com.omniwyse.dod.DTO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class MerchantPromotionBeaconSearchVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer merchantId;	
	private String product_id;
	private String productname;	
	private String product_image;
	private String originalPrice;
	private String discount;
	private Date createddate;
	private Date startdate;	
	private Date enddate;
	private String location;
	private Integer merchatId;
	private String brandName;
	private String brandRating;
	private String brandImage;
	private String brandDescription;
	private String categoryName;
	private Long catid;
	private Long brandId;
	private String discountText;
	private String Merchantfirstname;
	private String Merchantlastname;
	private String Merchantemailid;
	private String mobilenumber;
	private String businessname;
	private String businessoffaddr;
	private String landlineno;
	private String city;
	private String state;
	private String country;
	private String street;
	private String town;
	private String zipcode;
	private String description;
	private String tags;
	private Long beaconId;
	private String beaconName;
	private String beaconStatus;
	private Timestamp created;
	private Long aisleId;
	private String aisleName;
	private Integer xAxis;
	private Integer yAxis;
	private Integer floor;	
	private String nickname;
	private Long promotionId;
	public Integer getId() {
		return merchantId;
	}
	public void setId(Integer id) {
		this.merchantId = id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getMerchatId() {
		return merchatId;
	}
	public void setMerchatId(Integer merchatId) {
		this.merchatId = merchatId;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getCatid() {
		return catid;
	}
	public void setCatid(Long catid) {
		this.catid = catid;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public String getDiscountText() {
		return discountText;
	}
	public void setDiscountText(String discountText) {
		this.discountText = discountText;
	}
	public String getMerchantfirstname() {
		return Merchantfirstname;
	}
	public void setMerchantfirstname(String merchantfirstname) {
		Merchantfirstname = merchantfirstname;
	}
	public String getMerchantlastname() {
		return Merchantlastname;
	}
	public void setMerchantlastname(String merchantlastname) {
		Merchantlastname = merchantlastname;
	}
	public String getMerchantemailid() {
		return Merchantemailid;
	}
	public void setMerchantemailid(String merchantemailid) {
		Merchantemailid = merchantemailid;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getBusinessname() {
		return businessname;
	}
	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}
	public String getBusinessoffaddr() {
		return businessoffaddr;
	}
	public void setBusinessoffaddr(String businessoffaddr) {
		this.businessoffaddr = businessoffaddr;
	}
	public String getLandlineno() {
		return landlineno;
	}
	public void setLandlineno(String landlineno) {
		this.landlineno = landlineno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Long getBeaconId() {
		return beaconId;
	}
	public void setBeaconId(Long beaconId) {
		this.beaconId = beaconId;
	}
	public String getBeaconName() {
		return beaconName;
	}
	public void setBeaconName(String beaconName) {
		this.beaconName = beaconName;
	}
	public String getBeaconStatus() {
		return beaconStatus;
	}
	public void setBeaconStatus(String beaconStatus) {
		this.beaconStatus = beaconStatus;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Long getAisleId() {
		return aisleId;
	}
	public void setAisleId(Long aisleId) {
		this.aisleId = aisleId;
	}
	public String getAisleName() {
		return aisleName;
	}
	public void setAisleName(String aisleName) {
		this.aisleName = aisleName;
	}
	public Integer getxAxis() {
		return xAxis;
	}
	public void setxAxis(Integer xAxis) {
		this.xAxis = xAxis;
	}
	public Integer getyAxis() {
		return yAxis;
	}
	public void setyAxis(Integer yAxis) {
		this.yAxis = yAxis;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}
	public Long getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}
	
	
	
	
	
	
	
}







