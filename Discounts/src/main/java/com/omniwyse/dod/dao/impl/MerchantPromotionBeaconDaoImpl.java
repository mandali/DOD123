package com.omniwyse.dod.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.DTO.BeaconInformationVO;
import com.omniwyse.dod.dao.MerchantPromotionBeaconDao;
import com.omniwyse.dod.model.MerchantPromotionBeacon;
@Repository
public class MerchantPromotionBeaconDaoImpl implements MerchantPromotionBeaconDao{
	
	private static final Logger LOGGER = Logger.getLogger(MerchantPromotionBeaconDaoImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	final String METHOD_NAME = "MerchantPromotions";

	@SuppressWarnings("unchecked")
	public List<Object[]>  getbeacons() {
		final String METHOD_NAME = "getbeacons";
		List<Object[]> result = null;
		try{
			Session session = this.sessionFactory.getCurrentSession();
		result= session.createSQLQuery(" select distinct m.ID as MerchantId,mpb.A_ID as asileId,mpb.BC_ID as BeaconId,mpb.P_ID as promotionId from merchant_profile m join merchant_pm_bc mpb where m.ID=mpb.M_ID").list();
		}catch(Exception exception){
			LOGGER.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}		
		return result;
	}
		
	@SuppressWarnings("unchecked")
	public List<MerchantPromotionBeacon> fetchMerchantPromotionBeacons(BeaconInformationVO beaconInformationVO) {
		Session session;
		Query query;
		List<Long> bIds=new ArrayList<Long>();
		List<MerchantPromotionBeacon> merchantPromotionBeacons=new ArrayList<MerchantPromotionBeacon>();
		final String METHOD_NAME="fetchMerchantPromotionBeacons";
		try{
			
			session = this.sessionFactory.getCurrentSession();
			 query = (Query) session.createQuery(" from MerchantPromotionBeacon m where m.beacon.beaconId in (:beaconnames) ");
			 for(String string:beaconInformationVO.getBeaconIds()){
				 bIds.add(Long.valueOf(string));
			 }
			 merchantPromotionBeacons=query.setParameterList("beaconnames", bIds).list();			
		}
		catch(Exception  exception){
			LOGGER.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}		
		return merchantPromotionBeacons;
	}

}
