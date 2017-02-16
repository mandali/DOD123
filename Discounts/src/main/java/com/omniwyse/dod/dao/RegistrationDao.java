package com.omniwyse.dod.dao;

import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.model.UserProfile;

public interface RegistrationDao {
	
	public RegisterWithOtp Register(RegisterWithOtp registerWithOtp); 
	
	public UserProfile registeruser(UserProfile userProfile);	
	
	public ConsumerProfile registerconsumer(ConsumerProfile consumerProfile);	
	
	
}
