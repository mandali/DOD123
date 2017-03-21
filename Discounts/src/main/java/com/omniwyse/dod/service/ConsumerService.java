package com.omniwyse.dod.service;

import com.omniwyse.dod.model.ConsumerIdBaseProfile;
import com.omniwyse.dod.model.ConsumerLogin;
import com.omniwyse.dod.model.ConsumerLoginwithEmail;
import com.omniwyse.dod.model.ConsumerLoginwithMobile;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.ConsumerPromotionData;
import com.omniwyse.dod.model.RegisterWithOtp;

public interface ConsumerService {
	
	public ConsumerProfile registerConsumer(ConsumerProfile consumerProfile); 
	
	public RegisterWithOtp consumerLogin(ConsumerLogin userLogin); 
	
	public ConsumerProfile consumerAutheticateWithEmail(ConsumerLoginwithEmail userLogin); 
	
	public ConsumerProfile consumerAutheticateWithMobile(ConsumerLoginwithMobile userLogin); 
	
	public ConsumerProfile consumerProfile(ConsumerIdBaseProfile consumerIdBaseProfile);
	
	public RegisterWithOtp getMobileNo(RegisterWithOtp RegisterWithOtp); 
	
	public ConsumerPromotionData consumerPromotion(ConsumerPromotionData ConsumerPromotionData);
}
