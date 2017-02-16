package com.omniwyse.dod.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.dao.RegistrationDao;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.model.UserProfile;

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
		
		/*public MerchantProfile registermerchant(MerchantProfile merchantProfile) {			
			Session session = this.sessionFactory.getCurrentSession();
			Integer id = (Integer) session.save(merchantProfile);
			MerchantProfile resp=(MerchantProfile) session.get(MerchantProfile.class, id);		
			return resp;	
		}*/
		public ConsumerProfile registerconsumer(ConsumerProfile consumerProfile) {
			Session session = this.sessionFactory.getCurrentSession();			
			Integer id = (Integer) session.save(consumerProfile);
			ConsumerProfile resp=(ConsumerProfile) session.get(ConsumerProfile.class, id);				
			return resp;
		}
		
}
