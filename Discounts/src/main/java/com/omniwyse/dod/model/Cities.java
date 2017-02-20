package com.omniwyse.dod.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class Cities implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "CT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cityId;
	@Column(name ="CT_NAME")
	private String cityName;
	@OneToOne
	@JoinColumn(name="CO_ID")
	private Country countryId;
	@Column(name = "CT_CREATED")
	private Timestamp created;
	
	public Cities(){
		
	}

	public Cities(Long cityId, String cityName, Country countryId, Timestamp created) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.countryId = countryId;
		this.created = created;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Country getCountryId() {
		return countryId;
	}

	public void setCountryId(Country countryId) {
		this.countryId = countryId;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	
	
	
	

}
