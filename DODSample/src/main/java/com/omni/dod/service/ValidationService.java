package com.omni.dod.service;

import com.omni.dod.model.OTPValidation;
import com.omni.dod.model.RegisterWithOtp;

public interface ValidationService {
	
	public RegisterWithOtp Getotp(OTPValidation oTPValidation);
	

}
