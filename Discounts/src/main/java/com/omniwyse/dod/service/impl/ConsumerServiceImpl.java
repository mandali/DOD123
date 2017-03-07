package com.omniwyse.dod.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.dao.ConsumerDao;
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

	
	public ConsumerProfile consumerautheticatewithemail(ConsumerLoginwithEmail userLogin) {
		
		return consumerDao.consumerautheticatewithemail(userLogin);
	}
		
	public ConsumerProfile consumerautheticatewithMobile(ConsumerLoginwithMobile userLogin) {
		
		return consumerDao.consumerautheticatewithMobile(userLogin);
	}
		
	
	public RegisterWithOtp ConsumerLogin(ConsumerLogin userLogin) {
		
		return consumerDao.ConsumerLogin(userLogin);
	}
		
	public ConsumerProfile registerconsumer(ConsumerProfile consumerProfile) {
		Date date=new Date();
		consumerProfile.setCreateddate(date);
		ConsumerProfile resp=consumerDao.registerconsumer(consumerProfile);
		return resp;
	}
		
	public com.omniwyse.dod.model.ConsumerProfile ConsumerProfile(ConsumerIdBaseProfile consumerIdBaseProfile) {
		
		return consumerDao.ConsumerProfile(consumerIdBaseProfile);
	}
		
	public ConsumerPromotionData ConsumerPromotion(ConsumerPromotionData consumerPromotionData) {
		
		return consumerDao.ConsumerPromotion(consumerPromotionData);
	}
		

	}

