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

}
