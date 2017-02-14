package com.omniwyse.dod.dao.impl;

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

	public ConsumerProfile getmobilenoandemail(ConsumerProfile consumerProfile) {
		Session session = this.sessionFactory.openSession();
		Query query=(Query)session.createQuery("from ConsumerProfile where phone_no=:phoneno and email_id=:emailid")
				.setParameter("phoneno", consumerProfile.getPhone_no().trim())
				.setParameter("emailid",consumerProfile.getEmail_id().trim());		
		ConsumerProfile resp=(ConsumerProfile)query.uniqueResult();			
		return resp;		
	}
	public MerchantProfile getmobilenoandemail(MerchantProfile merchantProfile) {
		Session session = this.sessionFactory.openSession();
		Query query=(Query)session.createQuery("from MerchantProfile where mobilenumber=:phoneno and emailid=:emailid")
				.setParameter("phoneno", merchantProfile.getMobilenumber().trim())
				.setParameter("emailid", merchantProfile.getEmailid().trim());
		MerchantProfile resp=(MerchantProfile)query.uniqueResult();
		return resp;
	}
	public RegisterWithOtp getmobileno(RegisterWithOtp RegisterWithOtp) {
		Session session = this.sessionFactory.openSession();
		Query query=(Query)session.createQuery("from RegisterWithOtp where user_id=:userid")
				.setParameter("userid", RegisterWithOtp.getUser_id().trim());
		RegisterWithOtp resp=(RegisterWithOtp)query.uniqueResult();
		return resp;
	}
	public RegisterWithOtp getOTP(OTPValidation oTPValidation) {
		Session session = this.sessionFactory.openSession();
		Query query=(Query)session.createQuery("from RegisterWithOtp where otpno=:otpno and user_id=:mobile")				
				.setParameter("otpno",oTPValidation.getOtpno().trim())
				.setParameter("mobile", oTPValidation.getMobile().trim());
		RegisterWithOtp resp=(RegisterWithOtp)query.uniqueResult();
		return resp;
	}
}
