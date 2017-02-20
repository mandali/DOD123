package com.omniwyse.dod.dao;

import com.omniwyse.dod.model.ConsumerIdBaseProfile;
import com.omniwyse.dod.model.ConsumerLogin;
import com.omniwyse.dod.model.ConsumerLoginwithEmail;
import com.omniwyse.dod.model.ConsumerLoginwithMobile;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.RegisterWithOtp;

public interface ConsumerDao {
	
	public ConsumerProfile registerconsumer(ConsumerProfile consumerProfile);
	
	public ConsumerProfile consumerautheticatewithemail(ConsumerLoginwithEmail userLogin); 
	
	public ConsumerProfile consumerautheticatewithMobile(ConsumerLoginwithMobile userLogin);	
	
	public RegisterWithOtp ConsumerLogin(ConsumerLogin userLogin);	
	
	public ConsumerProfile ConsumerProfile(ConsumerIdBaseProfile ConsumerIdBaseProfile);
	
}
