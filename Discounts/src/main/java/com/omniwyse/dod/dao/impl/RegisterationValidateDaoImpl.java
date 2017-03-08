package com.omniwyse.dod.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.dao.RegisterationValidateDao;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.OTPValidation;
import com.omniwyse.dod.model.RegisterWithOtp;

@Repository
public class RegisterationValidateDaoImpl implements RegisterationValidateDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(RegisterationValidateDaoImpl.class);

	public ConsumerProfile getmobilenoandemail(ConsumerProfile consumerProfile) {
		final String METHOD_NAME="getmobilenoandemail";
		ConsumerProfile resp = null;
		try{
		Session session = this.sessionFactory.openSession();
		Query query=(Query)session.createQuery("from ConsumerProfile where phone_no=:phoneno and email_id=:emailid")
				.setParameter("phoneno", consumerProfile.getPhone_no().trim())
				.setParameter("emailid",consumerProfile.getEmail_id().trim());		
		 resp=(ConsumerProfile)query.uniqueResult();	
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());	
		}
		return resp;		
	}
		
	public MerchantProfile getmobilenoandemail(MerchantProfile merchantProfile) {
		final String METHOD_NAME="getmobilenoandemail";
		MerchantProfile resp = null;
		try{
		Session session = this.sessionFactory.openSession();
		Query query=(Query)session.createQuery("from MerchantProfile where mobilenumber=:phoneno and emailid=:emailid")
				.setParameter("phoneno", merchantProfile.getMobilenumber().trim())
				.setParameter("emailid", merchantProfile.getEmailid().trim());
		 resp=(MerchantProfile)query.uniqueResult();
		}catch(Exception  exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());	
		}
		return resp;
	}
		
	public RegisterWithOtp getmobileno(RegisterWithOtp RegisterWithOtp) {
		final String METHOD_NAME="getmobileno";
		RegisterWithOtp resp = null;
		try{
		Session session = this.sessionFactory.openSession();
		Query query=(Query)session.createQuery("from RegisterWithOtp where user_id=:userid")
				.setParameter("userid", RegisterWithOtp.getUser_id().trim());
		resp=(RegisterWithOtp)query.uniqueResult();
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());	

		}
		return resp;
	}
		
	public RegisterWithOtp getOTP(OTPValidation oTPValidation) {
		final String METHOD_NAME="getOTP";
		RegisterWithOtp resp = null;
		try{
		Session session = this.sessionFactory.openSession();
		Query query=(Query)session.createQuery("from RegisterWithOtp where otpno=:otpno and user_id=:mobile")				
				.setParameter("otpno",oTPValidation.getOtpno().trim())
				.setParameter("mobile", oTPValidation.getMobile().trim());
		resp=(RegisterWithOtp)query.uniqueResult();
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());	

		}
		return resp;
	}
		
}
