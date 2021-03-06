package com.omniwyse.dod.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.dao.ConsumerDao;
import com.omniwyse.dod.dao.RegisterationValidateDao;
import com.omniwyse.dod.model.ConsumerIdBaseProfile;
import com.omniwyse.dod.model.ConsumerLogin;
import com.omniwyse.dod.model.ConsumerLoginwithEmail;
import com.omniwyse.dod.model.ConsumerLoginwithMobile;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.ConsumerPromotionData;
import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.service.ConsumerService;

@Service
@Transactional
public class ConsumerServiceImpl implements ConsumerService{
	
	@Autowired
	ConsumerDao consumerDao;
	
	@Autowired
	RegisterationValidateDao consumerRegisterValidate;

	
	public ConsumerProfile consumerAutheticateWithEmail(ConsumerLoginwithEmail userLogin) {
		
		return consumerDao.consumerautheticatewithemail(userLogin);
	}		
	public ConsumerProfile consumerAutheticateWithMobile(ConsumerLoginwithMobile userLogin) {
		
		return consumerDao.consumerautheticatewithMobile(userLogin);
	}	
	public RegisterWithOtp consumerLogin(ConsumerLogin userLogin) {
		
		return consumerDao.consumerLogin(userLogin);
	}		
	public ConsumerProfile registerConsumer(ConsumerProfile consumerProfile) {
		Date date=new Date();
		consumerProfile.setCreateddate(date);
		ConsumerProfile resp=consumerDao.registerconsumer(consumerProfile);
		return resp;
	}		
	public com.omniwyse.dod.model.ConsumerProfile consumerProfile(ConsumerIdBaseProfile consumerIdBaseProfile) {
		
		return consumerDao.consumerProfile(consumerIdBaseProfile);
	}		
	public ConsumerPromotionData consumerPromotion(ConsumerPromotionData consumerPromotionData) {
		
		return consumerDao.consumerPromotion(consumerPromotionData);
	}
	public RegisterWithOtp getMobileNo(RegisterWithOtp RegisterWithOtp) {
		// TODO Auto-generated method stub
		return consumerRegisterValidate.getmobileno(RegisterWithOtp);
	}	

	}

