package com.omniwyse.dod.service;

import java.util.Date;
import java.util.List;

import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.model.UserProfile;

public interface RegistrationService {	
		
	public RegisterWithOtp Register(RegisterWithOtp registerWithOtp);
	
	public UserProfile registeruser(UserProfile userProfile);	
	
	public MerchantProfile registermerchant(MerchantProfile merchantProfile);
	
	public ConsumerProfile registerconsumer(ConsumerProfile consumerProfile); 
	
	
}
