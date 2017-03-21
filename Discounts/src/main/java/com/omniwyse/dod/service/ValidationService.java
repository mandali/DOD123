package com.omniwyse.dod.service;

import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.OTPValidation;
import com.omniwyse.dod.model.RegisterWithOtp;

public interface ValidationService {
	
	public RegisterWithOtp getOTP(OTPValidation oTPValidation);
	
	public ConsumerProfile getMobileNoAndEmail(ConsumerProfile consumerProfile); 
	
	public MerchantProfile getMobilenoAndEmail(MerchantProfile merchantProfile);
	
	

}
