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
@Table(name="merchant_beacon")
public class MerchantBeacon implements java.io.Serializable

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "BC_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long merchantBeaconId;
	@OneToOne
	@JoinColumn(name="B_ID")
	private Beacon beaconId;
	@OneToOne
	@JoinColumn(name="M_ID", referencedColumnName="ID")
	private MerchantProfile merchantProfile;
	
	public MerchantBeacon(){
	}
	
	

	public MerchantBeacon(Long merchantBeaconId, Beacon beaconId, MerchantProfile merchantProfile) {
		this.merchantBeaconId = merchantBeaconId;
		this.beaconId = beaconId;
		this.merchantProfile = merchantProfile;
	}



	public Long getMerchantBeaconId() {
		return merchantBeaconId;
	}

	public void setMerchantBeaconId(Long merchantBeaconId) {
		this.merchantBeaconId = merchantBeaconId;
	}

	public Beacon getBeaconId() {
		return beaconId;
	}

	public void setBeaconId(Beacon beaconId) {
		this.beaconId = beaconId;
	}

	public MerchantProfile getMerchantProfile() {
		return merchantProfile;
	}

	public void setMerchantProfile(MerchantProfile merchantProfile) {
		this.merchantProfile = merchantProfile;
	}
	
	
	

}
