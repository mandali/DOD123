package com.omniwyse.dod.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="merchant_ailes")
public class MerchantAisle implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "A_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aisleId;
	@OneToOne
	@JoinColumn(name = "M_ID", referencedColumnName="ID")
	private MerchantProfile merchantProfile;
	@OneToOne
	@JoinColumn(name="LO_ID")
	private Location location;
	@Column(name="A_NAME")
	private String aisleName;
	@Column(name="A_X")
	private Integer xAxis;
	@Column(name="A_Y")
	private Integer yAxis;
	@Column(name="A_FLOOR")
	private Integer floor;
	
	
	public MerchantAisle(){
		
	}
	
	
	public MerchantAisle(Long aisleId, MerchantProfile merchantProfile, Location location, String aisleName,
			Integer xAxis, Integer yAxis, Integer floor) {
		this.aisleId = aisleId;
		this.merchantProfile = merchantProfile;
		this.location = location;
		this.aisleName = aisleName;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.floor = floor;
	}




	public Long getAisleId() {
		return aisleId;
	}
	public void setAisleId(Long aisleId) {
		this.aisleId = aisleId;
	}
	public MerchantProfile getMerchantProfile() {
		return merchantProfile;
	}
	public void setMerchantProfile(MerchantProfile merchantProfile) {
		this.merchantProfile = merchantProfile;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
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
	
	
	
	

}
