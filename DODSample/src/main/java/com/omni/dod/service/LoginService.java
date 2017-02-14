package com.omni.dod.service;

import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantLogin;
import com.omni.dod.model.MerchantLoginwithEmail;
import com.omni.dod.model.MerchantLoginwithMobile;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.ConsumerLogin;
import com.omni.dod.model.ConsumerLoginwithEmail;
import com.omni.dod.model.ConsumerLoginwithMobile;

public interface LoginService {
	
	public ConsumerProfile ConsumerLogin(ConsumerLogin userLogin); 
	
	public MerchantProfile MerchatLogin(MerchantLogin merchantLogin);

	
	public ConsumerProfile consumerautheticatewithemail(ConsumerLoginwithEmail userLogin); 
	
	public ConsumerProfile consumerautheticatewithMobile(ConsumerLoginwithMobile userLogin);	
	
	public MerchantProfile merchatAutheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail);
	
	public MerchantProfile merchatAutheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile);

}
