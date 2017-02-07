package com.omni.dod.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omni.dod.dao.RegisterationValidateDao;
import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.RegisterWithOtp;

@Repository
public class RegisterationValidateDaoImpl implements RegisterationValidateDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public ConsumerProfile getmobilenoandemail(ConsumerProfile consumerProfile) {
		Session session = this.sessionFactory.openSession();
		Query query=(Query)session.createQuery("from ConsumerProfile where phone_no=:phoneno and email_id=:emailid")
				.setParameter("phoneno", consumerProfile.getPhone_no())
				.setParameter("emailid",consumerProfile.getEmail_id());		
		ConsumerProfile resp=(ConsumerProfile)query.uniqueResult();			
		return resp;
	}
	public MerchantProfile getmobilenoandemail(MerchantProfile merchantProfile) {
		Session session = this.sessionFactory.openSession();
		Query query=(Query)session.createQuery("from MerchantProfile where mobilenumber=:phoneno and emailid=:emailid")
				.setParameter("phoneno", merchantProfile.getMobilenumber())
				.setParameter("emailid", merchantProfile.getEmailid());
		MerchantProfile resp=(MerchantProfile)query.uniqueResult();
		return resp;
	}
	public RegisterWithOtp getmobileno(RegisterWithOtp RegisterWithOtp) {
		Session session = this.sessionFactory.openSession();
		Query query=(Query)session.createQuery("from RegisterWithOtp where user_id=:userid")
				.setParameter("userid", RegisterWithOtp.getUser_id());
		RegisterWithOtp resp=(RegisterWithOtp)query.uniqueResult();
		return resp;
	}
}
