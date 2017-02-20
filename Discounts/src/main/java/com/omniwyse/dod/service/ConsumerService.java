package com.omniwyse.dod.service;

import com.omniwyse.dod.model.ConsumerIdBaseProfile;
import com.omniwyse.dod.model.ConsumerLogin;
import com.omniwyse.dod.model.ConsumerLoginwithEmail;
import com.omniwyse.dod.model.ConsumerLoginwithMobile;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.RegisterWithOtp;

public interface ConsumerService {
	
	public ConsumerProfile registerconsumer(ConsumerProfile consumerProfile); 
	
	public RegisterWithOtp ConsumerLogin(ConsumerLogin userLogin); 
	
	public ConsumerProfile consumerautheticatewithemail(ConsumerLoginwithEmail userLogin); 
	
	public ConsumerProfile consumerautheticatewithMobile(ConsumerLoginwithMobile userLogin); 
	
	public ConsumerProfile ConsumerProfile(ConsumerIdBaseProfile consumerIdBaseProfile);
}
