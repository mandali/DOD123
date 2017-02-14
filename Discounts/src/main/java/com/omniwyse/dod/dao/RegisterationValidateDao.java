package com.omniwyse.dod.dao;

import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.OTPValidation;
import com.omniwyse.dod.model.RegisterWithOtp;

public interface RegisterationValidateDao {
	
	public ConsumerProfile getmobilenoandemail(ConsumerProfile consumerProfile); 
	
	public MerchantProfile getmobilenoandemail(MerchantProfile merchantProfile);
	
	public RegisterWithOtp getmobileno(RegisterWithOtp RegisterWithOtp); 
	
	public RegisterWithOtp getOTP(OTPValidation oTPValidation);
	
	
}
