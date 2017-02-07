package com.omni.dod.dao.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omni.dod.dao.RegistrationDao;
import com.omni.dod.model.Category;
import com.omni.dod.model.CategorySelection;
import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.Promotion;
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

		public List<Promotion> getPromotions(Date currentdate) {		
		Session session = this.sessionFactory.getCurrentSession();		
		List<Promotion> list = session.createQuery(" from Promotion p where :currentDate between p.startdate and p.enddate").setParameter("currentDate", currentdate).list();	    
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

		public List<Promotion> getCategoryPromotions(Date currentdate, CategorySelection categorySelection) { 
			Session session = this.sessionFactory.getCurrentSession();	
			List<Promotion> list = session.createQuery(" from Promotion p where :currentDate between p.startdate and p.enddate and p.category_name =:name ").setParameter("name", categorySelection.getCategoryname().trim()).setParameter("currentDate", currentdate).list();			
			return list;
		}		
		
	
}
