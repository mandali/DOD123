package com.omni.dod.dao;

import java.util.Date;
import java.util.List;

import com.omni.dod.model.ConsumerRegistration;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.Promotions;
import com.omni.dod.model.RegisterWithOtp;
import com.omni.dod.model.UserProfile;

public interface RegistrationDao {
	
	public ConsumerRegistration save(ConsumerRegistration consumerRegistration);
	
	public List<ConsumerRegistration> getConsumers();
	
	public RegisterWithOtp Register(RegisterWithOtp registerWithOtp); //ConsumerRegistration
	
	public UserProfile registeruser(UserProfile userProfile);
	
	public MerchantProfile registermerchant(MerchantProfile merchantProfile);
	
	
	
	public List<Promotions> getPromotions(Date currentdate);
	
}
