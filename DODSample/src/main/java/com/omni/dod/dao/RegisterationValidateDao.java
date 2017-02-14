package com.omni.dod.dao;

import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.OTPValidation;
import com.omni.dod.model.RegisterWithOtp;

public interface RegisterationValidateDao {
	
	public ConsumerProfile getmobilenoandemail(ConsumerProfile consumerProfile); 
	
	public MerchantProfile getmobilenoandemail(MerchantProfile merchantProfile);
	
	public RegisterWithOtp getmobileno(RegisterWithOtp RegisterWithOtp); 
	
	public RegisterWithOtp getOTP(OTPValidation oTPValidation);
	
	
}
