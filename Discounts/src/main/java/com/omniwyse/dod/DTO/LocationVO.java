package com.omniwyse.dod.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

public class LocationVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private Long locationId;
	private String locationName;
	private String locationLongitude;
	private String locationLatitude;
	private Long countryId;
	private Long cityId;
	private Timestamp created;
	
	public LocationVO(){
		
	}	
	
	
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLocationLongitude() {
		return locationLongitude;
	}
	public void setLocationLongitude(String locationLongitude) {
		this.locationLongitude = locationLongitude;
	}
	public String getLocationLatitude() {
		return locationLatitude;
	}
	public void setLocationLatitude(String locationLatitude) {
		this.locationLatitude = locationLatitude;
	}
	
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}	


	public Long getLocationId() {
		return locationId;
	}


	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}


	public Long getCountryId() {
		return countryId;
	}


	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}


	public Long getCityId() {
		return cityId;
	}


	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	
	
	
	
	

}
