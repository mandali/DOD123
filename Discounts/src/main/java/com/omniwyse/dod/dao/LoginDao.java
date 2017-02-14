package com.omni.dod.dao;

import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantLogin;
import com.omni.dod.model.MerchantLoginwithEmail;
import com.omni.dod.model.MerchantLoginwithMobile;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.ConsumerLogin;
import com.omni.dod.model.ConsumerLoginwithEmail;
import com.omni.dod.model.ConsumerLoginwithMobile;

public interface LoginDao {
	
	public ConsumerProfile consumerautheticatewithemail(ConsumerLoginwithEmail userLogin); 
	
	public ConsumerProfile consumerautheticatewithMobile(ConsumerLoginwithMobile userLogin);	
	
	public MerchantProfile merchantautheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail); 
	
	public MerchantProfile merchantautheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile);
	
	public ConsumerProfile ConsumerLogin(ConsumerLogin userLogin);
	
	public MerchantProfile MerchantLogin(MerchantLogin merchantLogin);
}
