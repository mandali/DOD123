package com.omniwyse.dod.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.DTO.BeaconInformationVO;
import com.omniwyse.dod.dao.MerchantPromotionBeaconDao;
import com.omniwyse.dod.model.MerchantPromotionBeacon;
import com.omniwyse.dod.service.MerchantPromotionBeaconService;

@Service
@Transactional
public class MerchantPromotionBeaconServiceImpl implements MerchantPromotionBeaconService{
	
	@Autowired
	MerchantPromotionBeaconDao merchantPromotionBeaconDao;

	public List<Object[]>  getbeacons() {
		
		return merchantPromotionBeaconDao.getbeacons();
	}
	/*===========================================================================================================*/	

	public List<MerchantPromotionBeacon> fetchMerchantPromotionBeacons(
			BeaconInformationVO beaconInformationVO) {
		// TODO Auto-generated method stub
		return merchantPromotionBeaconDao.fetchMerchantPromotionBeacons(beaconInformationVO);
	}
	/*===========================================================================================================*/	

}
