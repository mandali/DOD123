package com.omniwyse.dod.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="beacon")
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
	@Column(name = "B_UID")
	private String uid;
	@Column(name = "B_MAJ")
	private Integer major;
	@Column(name = "B_MIN")
	private Integer minor;
	
	public Beacon(){
	}
	
	


	public Beacon(Long beaconId, String beaconName, String beaconStatus, Timestamp created, String uid, Integer major,
			Integer minor) {
		this.beaconId = beaconId;
		this.beaconName = beaconName;
		this.beaconStatus = beaconStatus;
		this.created = created;
		this.uid = uid;
		this.major = major;
		this.minor = minor;
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
	
	public Integer getMajor() {
		return major;
	}
	public void setMajor(Integer major) {
		this.major = major;
	}
	public Integer getMinor() {
		return minor;
	}
	public void setMinor(Integer minor) {
		this.minor = minor;
	}




	public String getUid() {
		return uid;
	}




	public void setUid(String uid) {
		this.uid = uid;
	}	
	
	

}
