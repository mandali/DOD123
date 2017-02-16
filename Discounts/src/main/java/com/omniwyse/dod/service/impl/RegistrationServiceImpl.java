package com.omniwyse.dod.service.impl;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.dao.MerchantDao;
import com.omniwyse.dod.dao.RegistrationDao;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.model.UserProfile;
import com.omniwyse.dod.service.RegistrationService;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	RegistrationDao registrationDao;
	

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
	/*public MerchantProfile registermerchant(MerchantProfile merchantProfile) {
		Date date=new Date();
		merchantProfile.setCreateddate(date);
		MerchantProfile resp=registrationDao.registermerchant(merchantProfile);
		return resp;
	}*/
	public ConsumerProfile registerconsumer(ConsumerProfile consumerProfile) {		
		Date date=new Date();
		consumerProfile.setCreateddate(date);
		ConsumerProfile resp=registrationDao.registerconsumer(consumerProfile);
		return resp;		
	}	

}
