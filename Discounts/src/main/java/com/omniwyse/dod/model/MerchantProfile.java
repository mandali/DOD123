package com.omniwyse.dod.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;



@Entity
@Table(name = "merchant_profile")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MerchantProfile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;		
	
	@OneToMany(targetEntity =Promotion.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="Merchant_ID" ,referencedColumnName ="ID")
	private Set<Promotion> promotions;	
	
	@Column(name="first_name")
	private String firstname;
	@Column(name="logo")
	private String logo;	
	@Column(name="last_name")
	private String lastname;
	@Column(name="email_id")
	private String emailid;
	@Column(name="mobile_number")
	private String mobilenumber;	
	@Column(name="business_name")
	private String businessname;
	@Column(name="business_off_addr")
	private String businessoffaddr;
	@Column(name="landline_no")
	private String landlineno;
	@Column(name="city")
	private String city;	
	@Column(name="state")
	private String state;
	@Column(name="country")
	private String country;
	@Column(name="street")
	private String street;
	@Column(name="town")
	private String town;	
	@Column(name="zipcode")
	private String zipcode;
	@Column(name="description")
	private String description;
	@Column(name="tags")
	private String tags;	
	@Column(name="nickname")
	private String nickname;	
	@Column(name="password")
	private String password;	
	@Column(name="confirmpassword")
	private String confirmpassword;
	
	@Column(name = "created_date")
	private Date createddate;
	
	@OneToMany(targetEntity =Product.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="M_ID" ,referencedColumnName ="ID")
	private Set<Product> products;	
	
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getId() {
		return id;
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

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	

	public Set<Promotion> getPromotions() {
		return promotions;
	}
	public void setPromotions(Set<Promotion> promotions) {
		this.promotions = promotions;
	}
	
	
	
}
