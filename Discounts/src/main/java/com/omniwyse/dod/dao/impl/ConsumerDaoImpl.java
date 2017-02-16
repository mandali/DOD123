package com.omniwyse.dod.dao.impl;



import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.dao.ConsumerDao;
import com.omniwyse.dod.model.ConsumerLogin;
import com.omniwyse.dod.model.ConsumerLoginwithEmail;
import com.omniwyse.dod.model.ConsumerLoginwithMobile;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.RegisterWithOtp;
@Repository
public class ConsumerDaoImpl implements ConsumerDao {

	@Autowired
	SessionFactory sessionFactory;	
	
	public ConsumerProfile consumerautheticatewithemail(ConsumerLoginwithEmail userLogin) {		
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from ConsumerProfile where  password=:password and email_id=:email");		
		query.setParameter("password", userLogin.getPassword().trim());
		query.setParameter("email",userLogin.getEmail().trim());
		ConsumerProfile login=(ConsumerProfile)query.uniqueResult();			
		 return login;					
	}	
	public ConsumerProfile consumerautheticatewithMobile(ConsumerLoginwithMobile userLogin) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from ConsumerProfile where  password=:password and phone_no=:phoneno");
		query.setParameter("password", userLogin.getPassword().trim());
		query.setParameter("phoneno", userLogin.getMobile().trim());
		ConsumerProfile resp=(ConsumerProfile) query.uniqueResult();		
		return resp;
	}	
	public RegisterWithOtp ConsumerLogin(ConsumerLogin userLogin) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from RegisterWithOtp where user_id=:mobile");
		query.setParameter("mobile",userLogin.getMobileno());			
		RegisterWithOtp login=(RegisterWithOtp)query.uniqueResult();		
		 return login;
	}
	
}
