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
@Table(name="location")
public class Location implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "LO_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locationId;
	@Column(name = "LO_NAME")
	private String locationName;
	@Column(name = "LO_LAT")
	private String locationLatitude;
	@Column(name = "LO_LONG")
	private String locationLongitude;
	@OneToOne
	@JoinColumn(name = "CO_ID")
	private Country countryId;
	@OneToOne
	@JoinColumn(name = "CT_ID")
	private Cities citiesId;
	@Column(name = "LO_CREATED")
	private Timestamp created;

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Location() {
	}

	public Location(Long locationId, String locationName, String locationLatitude, String locationLongitude,
			Country countryId, Cities citiesId, Timestamp created) {
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationLatitude = locationLatitude;
		this.locationLongitude = locationLongitude;
		this.countryId = countryId;
		this.citiesId = citiesId;
		this.created=created;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationLatitude() {
		return locationLatitude;
	}

	public void setLocationLatitude(String locationLatitude) {
		this.locationLatitude = locationLatitude;
	}

	public String getLocationLongitude() {
		return locationLongitude;
	}

	public void setLocationLongitude(String locationLongitude) {
		this.locationLongitude = locationLongitude;
	}

	public Country getCountryId() {
		return countryId;
	}

	public void setCountryId(Country countryId) {
		this.countryId = countryId;
	}

	public Cities getCitiesId() {
		return citiesId;
	}

	public void setCitiesId(Cities citiesId) {
		this.citiesId = citiesId;
	}

}
