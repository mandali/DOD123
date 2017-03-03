package com.omniwyse.dod.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.DTO.MerchantPromotionBeaconSearchVo;
import com.omniwyse.dod.dao.MerchantPromotionBeaconDao;
@Repository
public class MerchantPromotionBeaconDaoImpl implements MerchantPromotionBeaconDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public List<Object[]>  getbeacons() {
		Session session = this.sessionFactory.openSession();
		List<Object[]> result= session.createSQLQuery(" select distinct m.ID as MerchantId,mpb.A_ID as asileId,mpb.BC_ID as BeaconId,mpb.P_ID as promotionId from merchant_profile m join merchant_pm_bc mpb where m.ID=mpb.M_ID").list();	
		return result;
	}

}
