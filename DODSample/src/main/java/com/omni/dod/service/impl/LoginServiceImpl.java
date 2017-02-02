package com.omni.dod.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omni.dod.dao.LoginDao;
import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantLogin;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.ConsumerLogin;
import com.omni.dod.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao loginDao;

	public ConsumerProfile autheticate(ConsumerLogin userLogin) {
		
		return loginDao.autheticate(userLogin);
	}

	public MerchantProfile merchatAutheticate(MerchantLogin merchantLogin) {
		
		return loginDao.autheticateLogin(merchantLogin);
	}

}
