package com.omni.dod.dao.impl;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omni.dod.dao.LoginDao;
import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantLogin;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.ConsumerLogin;
@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	SessionFactory sessionFactory;	
	
	public ConsumerProfile autheticate(ConsumerLogin userLogin) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from ConsumerProfile where phone_no=:username and password=:password");
		query.setParameter("username",userLogin.getUsername().trim());
		query.setParameter("password", userLogin.getPassword().trim());		
		ConsumerProfile login=(ConsumerProfile)query.uniqueResult();		
		 return login;					
	}

	public MerchantProfile autheticateLogin(MerchantLogin merchantLogin) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where mobile_number=:username and password=:password");
		query.setParameter("username", merchantLogin.getUsername().trim());
		query.setParameter("password", merchantLogin.getPassword().trim());
		MerchantProfile resp=(MerchantProfile) query.uniqueResult();
		return resp;
	}
}
