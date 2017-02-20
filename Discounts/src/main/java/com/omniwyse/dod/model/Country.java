package com.omniwyse.dod.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CO_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long countryId;
	@Column(name = "CO_NAME")
	private String countryName;
	@Column(name = "CO_CREATED")
	private Timestamp created;
	
	public Country(){
	}
	
	
	
	
	public Country(Long countryId, String countryName, Timestamp created) {
		this.countryId = countryId;
		this.countryName = countryName;
		this.created = created;
	}




	public Long getId() {
		return countryId;
	}
	public void setId(Long id) {
		this.countryId = id;
	}
	public String getName() {
		return countryName;
	}
	public void setName(String name) {
		this.countryName = name;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	
	

}
