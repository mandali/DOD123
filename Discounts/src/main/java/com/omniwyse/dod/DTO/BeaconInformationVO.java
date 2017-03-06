package com.omniwyse.dod.DTO;

import java.util.ArrayList;
import java.util.List;

public class BeaconInformationVO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public BeaconInformationVO(){
		
	}
	
	
	private List<String> beaconIds=new ArrayList<String>();



	public List<String> getBeaconIds() {
		return beaconIds;
	}


	public void setBeaconIds(List<String> beaconIds) {
		this.beaconIds = beaconIds;
	}


	
	

}
