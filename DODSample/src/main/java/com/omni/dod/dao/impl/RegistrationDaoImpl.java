package com.omni.dod.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omni.dod.dao.RegistrationDao;
import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.Promotions;
import com.omni.dod.model.RegisterWithOtp;
import com.omni.dod.model.UserProfile;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {
	@Autowired
	SessionFactory sessionFactory;

	public RegisterWithOtp Register(RegisterWithOtp registerWithOtp) {		
		Session session = this.sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(registerWithOtp);
		RegisterWithOtp reg=(RegisterWithOtp) session.get(RegisterWithOtp.class, id);
		return reg;
	}

	public UserProfile registeruser(UserProfile userProfile) {		
		Session session = this.sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(userProfile);
		UserProfile resp=(UserProfile) session.get(UserProfile.class, id);		
		return resp;
	}

		public List<Promotions> getPromotions(Date currentdate) {		
		Session session = this.sessionFactory.getCurrentSession();		
		List<Promotions> list = session.createQuery("from Promotions p where :currentDate between p.startdate and p.enddate").setParameter("currentDate", currentdate).list();
		System.out.println(list.size());
		return list;
	}

		public MerchantProfile registermerchant(MerchantProfile merchantProfile) {
			
			Session session = this.sessionFactory.getCurrentSession();
			Integer id = (Integer) session.save(merchantProfile);
			MerchantProfile resp=(MerchantProfile) session.get(MerchantProfile.class, id);		
			return resp;			
	
		}

		public ConsumerProfile registerconsumer(ConsumerProfile consumerProfile) {
			Session session = this.sessionFactory.getCurrentSession();
			Integer id = (Integer) session.save(consumerProfile);
			ConsumerProfile resp=(ConsumerProfile) session.get(ConsumerProfile.class, id);		
			return resp;
		}		
		
	
}
