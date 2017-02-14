package com.omni.dod.dao.impl;



import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omni.dod.dao.LoginDao;
import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantLogin;
import com.omni.dod.model.MerchantLoginwithEmail;
import com.omni.dod.model.MerchantLoginwithMobile;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.ConsumerLogin;
import com.omni.dod.model.ConsumerLoginwithEmail;
import com.omni.dod.model.ConsumerLoginwithMobile;
@Repository
public class LoginDaoImpl implements LoginDao {

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
	public MerchantProfile merchantautheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail) {		
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where  password=:password and emailid=:emalid");
		query.setParameter("password", merchantLoginwithEmail.getPassword());
		query.setParameter("emalid", merchantLoginwithEmail.getEmail());
		MerchantProfile resp=(MerchantProfile) query.uniqueResult();		
		return resp;
	}
	public MerchantProfile merchantautheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where  password=:password and mobilenumber=:mobile");
		query.setParameter("password", merchantLoginwithMobile.getPassword().trim());
		query.setParameter("mobile", merchantLoginwithMobile.getMobileno().trim());
		MerchantProfile resp=(MerchantProfile) query.uniqueResult();		
		return resp;		
	}
	public ConsumerProfile ConsumerLogin(ConsumerLogin userLogin) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from ConsumerProfile where phone_no=:mobile");
		query.setParameter("mobile",userLogin.getMobileno());			
		ConsumerProfile login=(ConsumerProfile)query.uniqueResult();		
		 return login;
	}
	public MerchantProfile MerchantLogin(MerchantLogin merchantLogin) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where mobilenumber=:mobileno and password=:password");
		query.setParameter("mobileno", merchantLogin.getMobileno().trim())
		.setParameter("password", merchantLogin.getPassword().trim());		
		MerchantProfile resp=(MerchantProfile) query.uniqueResult();
		return resp;

	}	
}
