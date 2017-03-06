package com.omniwyse.dod.dao;

import java.util.List;

import com.omniwyse.dod.DTO.BeaconInformationVO;
import com.omniwyse.dod.model.MerchantPromotionBeacon;

public interface MerchantPromotionBeaconDao {
	
	public List<Object[]>  getbeacons();
	
	public List<MerchantPromotionBeacon> fetchMerchantPromotionBeacons(BeaconInformationVO beaconInformationVO);

}
