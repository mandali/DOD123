package com.omniwyse.dod.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Beacon implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "B_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long beaconId;
	@Column(name ="B_NAME")
	private String beaconName;
	@Column(name="B_STATUS")
	private String beaconStatus;
	@Column(name = "BRD_CREATED")
	private Timestamp created;
	
	public Beacon(){
	}
	
	
	
	
	public Beacon(Long beaconId, String beaconName, String beaconStatus, Timestamp created) {
		this.beaconId = beaconId;
		this.beaconName = beaconName;
		this.beaconStatus = beaconStatus;
		this.created = created;
	}




	public Long getBeaconId() {
		return beaconId;
	}
	public void setBeaconId(Long beaconId) {
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
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	

}
