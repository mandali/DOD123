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
@Table(name="merchant_pm_bc")
public class MerchantPromotionBeacon implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "MPB_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mpbId;
	@OneToOne
	@JoinColumn(name="B_ID")
	private Beacon beacon;
	@OneToOne
	@JoinColumn(name="M_ID", referencedColumnName="ID")
	private MerchantProfile merchantProfile;
	@OneToOne
	@JoinColumn(name="P_ID" ,referencedColumnName ="PRMS_ID")
	private Promotion promotion;
	@OneToOne
	@JoinColumn(name="A_ID")
	private MerchantAisle merchantAisle;
	
	
	public MerchantPromotionBeacon(){
		
	}


	public Long getMpbId() {
		return mpbId;
	}


	public void setMpbId(Long mpbId) {
		this.mpbId = mpbId;
	}


	public Beacon getBeacon() {
		return beacon;
	}


	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}


	public MerchantProfile getMerchantProfile() {
		return merchantProfile;
	}


	public void setMerchantProfile(MerchantProfile merchantProfile) {
		this.merchantProfile = merchantProfile;
	}


	public Promotion getPromotion() {
		return promotion;
	}


	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}


	public MerchantAisle getMerchantAisle() {
		return merchantAisle;
	}


	public void setMerchantAisle(MerchantAisle merchantAisle) {
		this.merchantAisle = merchantAisle;
	}
	
	
	

}
