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
public class Promotion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "PRMS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	@JoinColumn(name = "P_ID")
	private Product productID;
	@Column(name = "PRMS_DESC")
	private String description;
	@OneToOne
	@JoinColumn(name = "Merchant_ID", referencedColumnName = "ID")
	private MerchantProfile merchatId;
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
	@OneToOne
	@JoinColumn(name = "LO_ID")
	private Location locationId;
	@OneToOne
	@JoinColumn(name = "CAT_ID")
	private Category catid;
	@ManyToOne
	@JoinColumn(name = "BRD_ID")
	private Brand brandId;
	@Column(name = "PRMS_DISC_TXT")
	private String discountText;

	public Promotion() {
	}

	public Promotion(Integer id, Product productID, String description, MerchantProfile merchatId, String originalPrice,
			String discount, Date createddate, Date startdate, Date enddate, Location locationId, Category catid,
			Brand brandId, String discountText) {
		this.id = id;
		this.productID = productID;
		this.description = description;
		this.merchatId = merchatId;
		this.originalPrice = originalPrice;
		this.discount = discount;
		this.createddate = createddate;
		this.startdate = startdate;
		this.enddate = enddate;
		this.locationId = locationId;
		this.catid = catid;
		this.brandId = brandId;
		this.discountText = discountText;
	}

	public Category getCatid() {
		return catid;
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

	public Location getLocationId() {
		return locationId;
	}

	public void setLocationId(Location locationId) {
		this.locationId = locationId;
	}

	public MerchantProfile getMerchatId() {
		return merchatId;
	}

	public void setMerchatId(MerchantProfile merchatId) {
		this.merchatId = merchatId;
	}

	public Product getProductID() {
		return productID;
	}

	public void setProductID(Product productID) {
		this.productID = productID;
	}

}
