package com.omniwyse.dod.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.dao.ConsumerDao;
import com.omniwyse.dod.model.ConsumerLogin;
import com.omniwyse.dod.model.ConsumerLoginwithEmail;
import com.omniwyse.dod.model.ConsumerLoginwithMobile;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.service.ConsumerService;

@Service
@Transactional
public class ConsumerServiceImpl implements ConsumerService{
	
	@Autowired
	ConsumerDao loginDao;

	
	public ConsumerProfile consumerautheticatewithemail(ConsumerLoginwithEmail userLogin) {
		
		return loginDao.consumerautheticatewithemail(userLogin);
	}
	public ConsumerProfile consumerautheticatewithMobile(ConsumerLoginwithMobile userLogin) {
		
		return loginDao.consumerautheticatewithMobile(userLogin);
	}
	
	public RegisterWithOtp ConsumerLogin(ConsumerLogin userLogin) {
		
		return loginDao.ConsumerLogin(userLogin);
	}	

	}

