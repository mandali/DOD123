package com.omniwyse.dod.DTO;

import java.io.Serializable;

public class IBeaconVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String beaconUID;
	private String beaconMinorValue;
	private String beaconMajorValue;
	
	public IBeaconVO(){
	}

	public String getBeaconUID() {
		return beaconUID;
	}

	public void setBeaconUID(String beaconUID) {
		this.beaconUID = beaconUID;
	}

	public String getBeaconMinorValue() {
		return beaconMinorValue;
	}

	public void setBeaconMinorValue(String beaconMinorValue) {
		this.beaconMinorValue = beaconMinorValue;
	}

	public String getBeaconMajorValue() {
		return beaconMajorValue;
	}

	public void setBeaconMajorValue(String beaconMajorValue) {
		this.beaconMajorValue = beaconMajorValue;
	}

	
	
	
}
