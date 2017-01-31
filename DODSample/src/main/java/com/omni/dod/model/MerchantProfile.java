package com.omni.dod.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "merchant_profile")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MerchantProfile {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="first_name")
	String firstname;
	@Column(name="last_name")
	String lastname;
	@Column(name="email_id")
	String emailid;
	@Column(name="mobile_number")
	String mobilenumber;	
	@Column(name="business_name")
	String businessname;
	@Column(name="business_off_addr")
	String businessoffaddr;
	@Column(name="landline_no")
	String landlineno;
	@Column(name="city")
	String city;	
	@Column(name="state")
	String state;
	@Column(name="country")
	String country;
	@Column(name="street")
	String street;
	@Column(name="town")
	String town;	
	@Column(name="zipcode")
	String zipcode;
	@Column(name="description")
	String description;
	@Column(name="tags")
	String tags;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	@Column(name="nickname")
	String nickname;
	
	@Column(name="password")
	String password;
	
	@Column(name="confirmpassword")
	String confirmpassword;
	
	
	
	
	
	@Column(name = "created_date")
	private Date createddate;
	
	
	public Integer getId() {
		return id;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(java.util.Date date) {
		this.createddate = date;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
