package com.omni.dod.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omni.dod.dao.RegisterationValidateDao;
import com.omni.dod.model.OTPValidation;
import com.omni.dod.model.RegisterWithOtp;
import com.omni.dod.service.ValidationService;

@Service
@Transactional
public class ValidationServiceImpl implements ValidationService{

	@Autowired
	RegisterationValidateDao registerationValidateDao;
	
	public RegisterWithOtp Getotp(OTPValidation oTPValidation) {
		
	return registerationValidateDao.getOTP(oTPValidation);
		
	}

}
