package com.omni.dod.service;

import java.util.Date;
import java.util.List;

import com.omni.dod.model.ConsumerRegistration;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.Promotions;
import com.omni.dod.model.RegisterWithOtp;
import com.omni.dod.model.UserProfile;

public interface RegistrationService {
	
	//public ConsumerRegistration save(ConsumerRegistration consumerRegistration);
	
	public List<ConsumerRegistration> getConsumers(); 
	
	public RegisterWithOtp Register(RegisterWithOtp registerWithOtp);
	
	public UserProfile registeruser(UserProfile userProfile);
	
	
	public MerchantProfile registermerchant(MerchantProfile merchantProfile);
	
	public List<Promotions> getPromotions(Date currentdate);
	
	
}
