package com.omni.dod.dao;

import java.util.Date;
import java.util.List;

import com.omni.dod.model.Category;
import com.omni.dod.model.CategorySelection;
import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.Promotion;
import com.omni.dod.model.RegisterWithOtp;
import com.omni.dod.model.UserProfile;

public interface RegistrationDao {
	
	public RegisterWithOtp Register(RegisterWithOtp registerWithOtp); 
	
	public UserProfile registeruser(UserProfile userProfile);
	
	public MerchantProfile registermerchant(MerchantProfile merchantProfile);
	
	public ConsumerProfile registerconsumer(ConsumerProfile consumerProfile);	
	
	public List<Promotion> getPromotions(Date currentdate); 
	
	public List<Promotion> getCategoryPromotions(Date currentdate, CategorySelection categorySelection);
	
}
