package com.omni.dod.model;

import java.util.Calendar;
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
public class Promotions {
	
	@Id
	@Column(name = "PRMS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prmsid;
	@Column(name = "M_ID")
	private String marchant_id;
	@Column(name = "P_ID")
	private String product_id;
	@Column(name = "PRMS_DESC")
	private String prms_desc;
	@Column(name = "ORGI_PRICE")
	private String orginal_price;
	@Column(name = "OFFER_PRICE")
	private String offer_price;
	@Column(name = "DIS_PER")
	private String discount_price;
	@Column(name = "CRETATED_DATE")
	private Date createddate;
	@Column(name = "START_DATE")
	private Date startdate;	
	@Column(name = "END_DATE")
	private Date enddate;
	
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
	public Integer getPrmsid() {
		return prmsid;
	}
	public void setPrmsid(Integer prmsid) {
		this.prmsid = prmsid;
	}
	public String getMarchant_id() {
		return marchant_id;
	}
	public void setMarchant_id(String marchant_id) {
		this.marchant_id = marchant_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getPrms_desc() {
		return prms_desc;
	}
	public void setPrms_desc(String prms_desc) {
		this.prms_desc = prms_desc;
	}
	public String getOrginal_price() {
		return orginal_price;
	}
	public void setOrginal_price(String orginal_price) {
		this.orginal_price = orginal_price;
	}
	public String getOffer_price() {
		return offer_price;
	}
	public void setOffer_price(String offer_price) {
		this.offer_price = offer_price;
	}
	public String getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(String discount_price) {
		this.discount_price = discount_price;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
		

}
