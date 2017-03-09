package com.omniwyse.dod.DTO;

import java.sql.Timestamp;

public class BeaconVO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BeaconVO(){
	}
	
	private String beaconId;
	private String beaconName;
	private String beaconStatus;
	private Timestamp createdDate;

	public String getBeaconId() {
		return beaconId;
	}
	public void setBeaconId(String beaconId) {
		this.beaconId = beaconId;
	}
	public String getBeaconName() {
		return beaconName;
	}
	public void setBeaconName(String beaconName) {
		this.beaconName = beaconName;
	}
	public String getBeaconStatus() {
		return beaconStatus;
	}
	public void setBeaconStatus(String beaconStatus) {
		this.beaconStatus = beaconStatus;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	
	
}
