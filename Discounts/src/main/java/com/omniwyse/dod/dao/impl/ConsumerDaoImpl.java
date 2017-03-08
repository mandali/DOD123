package com.omniwyse.dod.dao.impl;



import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.dao.ConsumerDao;
import com.omniwyse.dod.model.ConsumerIdBaseProfile;
import com.omniwyse.dod.model.ConsumerLogin;
import com.omniwyse.dod.model.ConsumerLoginwithEmail;
import com.omniwyse.dod.model.ConsumerLoginwithMobile;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.ConsumerPromotionData;
import com.omniwyse.dod.model.RegisterWithOtp;
@Repository
public class ConsumerDaoImpl implements ConsumerDao {

	@Autowired
	SessionFactory sessionFactory;	
	
	private static final Logger logger = Logger.getLogger(ConsumerDaoImpl.class);
	
	public ConsumerProfile consumerautheticatewithemail(ConsumerLoginwithEmail userLogin) {	
		ConsumerProfile login = null; 
		final String METHOD_NAME = "consumerautheticatewithemail";
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from ConsumerProfile where  password=:password and email_id=:email");		
		query.setParameter("password", userLogin.getPassword().trim());
		query.setParameter("email",userLogin.getEmail().trim());
		login=(ConsumerProfile)query.uniqueResult();		
		}catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());			
		}
		 return login;
	}
		
	public ConsumerProfile consumerautheticatewithMobile(ConsumerLoginwithMobile userLogin) {
		final String METHOD_NAME = "consumerautheticatewithMobile";
		ConsumerProfile resp=null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from ConsumerProfile where  password=:password and phone_no=:phoneno");
		query.setParameter("password", userLogin.getPassword().trim());
		query.setParameter("phoneno", userLogin.getMobile().trim());
		resp =(ConsumerProfile) query.uniqueResult();
		}catch(Exception exception)
		{
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
			
		}
		return resp;
	}
		
	public RegisterWithOtp ConsumerLogin(ConsumerLogin userLogin) {
		final String METHOD_NAME = "ConsumerLogin";
		RegisterWithOtp login=null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from RegisterWithOtp where user_id=:mobile");
		query.setParameter("mobile",userLogin.getMobileno());			
		 login=(RegisterWithOtp)query.uniqueResult();
		}catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		 return login;
	}
		
	public ConsumerProfile registerconsumer(ConsumerProfile consumerProfile) {
		final String METHOD_NAME = "registerconsumer";
		ConsumerProfile resp=null;
		try{
		Session session = this.sessionFactory.getCurrentSession();			
		Integer id = (Integer) session.save(consumerProfile);
		 resp=(ConsumerProfile) session.get(ConsumerProfile.class, id);
		}catch(Exception exception)
		{
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return resp;
	}
		
	public ConsumerProfile ConsumerProfile(ConsumerIdBaseProfile ConsumerIdBaseProfile) {
		final String METHOD_NAME = "ConsumerProfile";
		ConsumerProfile resp = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from ConsumerProfile where phone_no=:mobileno");
		query.setParameter("mobileno", ConsumerIdBaseProfile.getMobileno().trim());		
		 resp=(ConsumerProfile) query.uniqueResult();	
		}catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return resp;
	}
		
	public ConsumerPromotionData ConsumerPromotion(ConsumerPromotionData consumerPromotionData) {
		final String METHOD_NAME = "ConsumerPromotion";
		ConsumerPromotionData resp = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();			
		Integer id = (Integer) session.save(consumerPromotionData);
		resp=(ConsumerPromotionData) session.get(ConsumerPromotionData.class, id);
		}catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return resp;
	}
		
	
}
