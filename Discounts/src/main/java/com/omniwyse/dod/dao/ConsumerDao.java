package com.omniwyse.dod.dao;

import com.omniwyse.dod.model.ConsumerLogin;
import com.omniwyse.dod.model.ConsumerLoginwithEmail;
import com.omniwyse.dod.model.ConsumerLoginwithMobile;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.RegisterWithOtp;

public interface LoginDao {
	
	public ConsumerProfile consumerautheticatewithemail(ConsumerLoginwithEmail userLogin); 
	
	public ConsumerProfile consumerautheticatewithMobile(ConsumerLoginwithMobile userLogin);	
	
	public MerchantProfile merchantautheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail); 
	
	public MerchantProfile merchantautheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile);
	
	public RegisterWithOtp ConsumerLogin(ConsumerLogin userLogin);
	
	public MerchantProfile MerchantLogin(MerchantLogin merchantLogin);
}
