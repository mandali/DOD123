package com.omni.dod.service.impl;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omni.dod.dao.RegistrationDao;
import com.omni.dod.model.ConsumerRegistration;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.Promotions;
import com.omni.dod.model.RegisterWithOtp;
import com.omni.dod.model.UserProfile;
import com.omni.dod.service.RegistrationService;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	RegistrationDao registrationDao;
	
	public ConsumerRegistration save(ConsumerRegistration consumerRegistration) {
		ConsumerRegistration cons=	registrationDao.save(consumerRegistration);				
		return cons;
	}	
	public List<ConsumerRegistration> getConsumers() {
		
		return registrationDao.getConsumers();
	}	
	
	
	

	public RegisterWithOtp Register(RegisterWithOtp registerWithOtp) {
		
		Date date=new Date();
		registerWithOtp.setExpdate(date);	
		registerWithOtp.setCreatedate(date);
		registerWithOtp.setOtpno("1234");
		RegisterWithOtp con=registrationDao.Register(registerWithOtp);		
		return con;
	}
	public UserProfile registeruser(UserProfile userProfile) {		
		Date date=new Date();
		userProfile.setCreteddate(date);
		UserProfile resp=registrationDao.registeruser(userProfile);		
		return resp;
	}
	
	public MerchantProfile registermerchant(MerchantProfile merchantProfile) {
		Date date=new Date();
		merchantProfile.setCreateddate(date);
		MerchantProfile resp=registrationDao.registermerchant(merchantProfile);
		return resp;
	}
	public List<Promotions> getPromotions(Date currentdate) {				
		return registrationDao.getPromotions(currentdate);
		
	}
	

	

	

}
