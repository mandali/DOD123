package com.omniwyse.dod.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.dao.RegisterationValidateDao;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.OTPValidation;
import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.service.ValidationService;

@Service
@Transactional
public class ValidationServiceImpl implements ValidationService{

	@Autowired
	RegisterationValidateDao registerationValidateDao;
	
	@Autowired
	RegisterationValidateDao consumerRegisterValidate;
	
	public RegisterWithOtp getotp(OTPValidation oTPValidation) {
		
	return registerationValidateDao.getOTP(oTPValidation);
		
	}

	public ConsumerProfile getmobilenoandemail(ConsumerProfile consumerProfile) {
		// TODO Auto-generated method stub
		return consumerRegisterValidate.getmobilenoandemail(consumerProfile);
	}

	public MerchantProfile getmobilenoandemail(MerchantProfile merchantProfile) {
		// TODO Auto-generated method stub
		return consumerRegisterValidate.getmobilenoandemail(merchantProfile);
	}
}
