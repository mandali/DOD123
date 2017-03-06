package com.omniwyse.dod.service;

import java.util.List;

import com.omniwyse.dod.DTO.BeaconInformationVO;
import com.omniwyse.dod.model.MerchantPromotionBeacon;

public interface MerchantPromotionBeaconService {
	
	public List<Object[]>  getbeacons();
	
	public List<MerchantPromotionBeacon> fetchMerchantPromotionBeacons(BeaconInformationVO beaconInformationVO);

}
