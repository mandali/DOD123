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
@Table(name="product")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Product  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "P_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
	@Column(name = "P_DESC")
	private String productDescription;
	@Column(name = "IMAGE_LOC")
	private String productImageLocation;
	@Column(name = "CRETATED_DATE")
	private Timestamp productCreatedDate;
	@OneToOne
	@JoinColumn(name = "M_ID",referencedColumnName="ID")
	private MerchantProfile merchantId;
	
	public Product(){
	}
	public Product(Long productId, String productDescription, String productImageLocation, Timestamp productCreatedDate,
			MerchantProfile merchantId) {
		this.productId = productId;
		this.productDescription = productDescription;
		this.productImageLocation = productImageLocation;
		this.productCreatedDate = productCreatedDate;
		this.merchantId = merchantId;
	}
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImageLocation() {
		return productImageLocation;
	}

	public void setProductImageLocation(String productImageLocation) {
		this.productImageLocation = productImageLocation;
	}

	public Timestamp getProductCreatedDate() {
		return productCreatedDate;
	}

	public void setProductCreatedDate(Timestamp productCreatedDate) {
		this.productCreatedDate = productCreatedDate;
	}
	public MerchantProfile getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(MerchantProfile merchantId) {
		this.merchantId = merchantId;
	}	

}
