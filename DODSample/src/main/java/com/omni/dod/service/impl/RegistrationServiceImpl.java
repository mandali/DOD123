package com.omni.dod.service.impl;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omni.dod.dao.RegistrationDao;
import com.omni.dod.model.Category;
import com.omni.dod.model.CategorySelection;
import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.Promotion;
import com.omni.dod.model.RegisterWithOtp;
import com.omni.dod.model.UserProfile;
import com.omni.dod.service.RegistrationService;

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
	public MerchantProfile registermerchant(MerchantProfile merchantProfile) {
		Date date=new Date();
		merchantProfile.setCreateddate(date);
		MerchantProfile resp=registrationDao.registermerchant(merchantProfile);
		return resp;
	}
	public ConsumerProfile registerconsumer(ConsumerProfile consumerProfile) {		
		Date date=new Date();
		consumerProfile.setCreateddate(date);
		ConsumerProfile resp=registrationDao.registerconsumer(consumerProfile);
		return resp;		
	}
	public List<Promotion> getPromotions(Date currentdate) {			
		
		return registrationDao.getPromotions(currentdate);
	}
	
	public List<Promotion> getCategoryPromotions(Date currentdate, CategorySelection categorySelection) {		
		return registrationDao.getCategoryPromotions(currentdate, categorySelection);
	}
	public Promotion CreatePromotions(Promotion promotion) {
		Date date=new Date();
		promotion.setCreateddate(date);
		promotion.setStartdate(date);
		promotion.setEnddate(date);
		return registrationDao.CreatePromotions(promotion);
	}
	

	

	

}
