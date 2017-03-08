package com.omniwyse.dod.service;

import com.omniwyse.dod.model.OTPValidation;
import com.omniwyse.dod.model.RegisterWithOtp;

public interface ValidationService {
	
	public RegisterWithOtp getotp(OTPValidation oTPValidation);
	

}
