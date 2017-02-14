package com.omni.dod.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omni.dod.dao.LoginDao;
import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantLogin;
import com.omni.dod.model.MerchantLoginwithEmail;
import com.omni.dod.model.MerchantLoginwithMobile;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.ConsumerLogin;
import com.omni.dod.model.ConsumerLoginwithEmail;
import com.omni.dod.model.ConsumerLoginwithMobile;
import com.omni.dod.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao loginDao;

	public MerchantProfile merchatAutheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail) {
		
		return loginDao.merchantautheticateWithEmail(merchantLoginwithEmail);
	}
	public ConsumerProfile consumerautheticatewithemail(ConsumerLoginwithEmail userLogin) {
		
		return loginDao.consumerautheticatewithemail(userLogin);
	}
	public ConsumerProfile consumerautheticatewithMobile(ConsumerLoginwithMobile userLogin) {
		
		return loginDao.consumerautheticatewithMobile(userLogin);
	}
	public MerchantProfile merchatAutheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile) {
		
		return loginDao.merchantautheticateWithMobile(merchantLoginwithMobile);
	}
	
	public ConsumerProfile ConsumerLogin(ConsumerLogin userLogin) {
		
		return loginDao.ConsumerLogin(userLogin);
	}
	public MerchantProfile MerchatLogin(MerchantLogin merchantLogin) {
		
		return loginDao.MerchantLogin(merchantLogin);
	}

	}

