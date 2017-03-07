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
import com.omniwyse.dod.config.AppConfiguration;
import com.omniwyse.dod.dao.MerchantPromotionBeaconDao;
import com.omniwyse.dod.model.MerchantPromotionBeacon;
@Repository
public class MerchantPromotionBeaconDaoImpl implements MerchantPromotionBeaconDao{
	
	private static final Logger logger = Logger.getLogger(AppConfiguration.class);
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Object[]>  getbeacons() {
		Session session = this.sessionFactory.openSession();
		List<Object[]> result= session.createSQLQuery(" select distinct m.ID as MerchantId,mpb.A_ID as asileId,mpb.BC_ID as BeaconId,mpb.P_ID as promotionId from merchant_profile m join merchant_pm_bc mpb where m.ID=mpb.M_ID").list();	
		return result;
	}
	/*===========================================================================================================*/	
	@SuppressWarnings("unchecked")
	public List<MerchantPromotionBeacon> fetchMerchantPromotionBeacons(BeaconInformationVO beaconInformationVO) {
		Session session;
		Query query;
		List<Long> bIds=new ArrayList<Long>();
		List<MerchantPromotionBeacon> merchantPromotionBeacons=new ArrayList<MerchantPromotionBeacon>();
		final String METHOD_NAME="fetchMerchantPromotionBeacons";
		try{
			
			 session = this.sessionFactory.openSession();
			 query = (Query) session.createQuery(" from MerchantPromotionBeacon m where m.beacon.beaconId in (:beaconnames) ");
			 for(String string:beaconInformationVO.getBeaconIds()){
				 bIds.add(Long.valueOf(string));
			 }
			 merchantPromotionBeacons=query.setParameterList("beaconnames", bIds).list();			
		}
		catch(Exception  exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}		
		return merchantPromotionBeacons;
	}

}
