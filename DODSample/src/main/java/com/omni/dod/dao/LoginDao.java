package com.omni.dod.dao;

import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantLogin;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.ConsumerLogin;

public interface LoginDao {
	
	public ConsumerProfile autheticate(ConsumerLogin userLogin); 
	
	public MerchantProfile autheticateLogin(MerchantLogin merchantLogin); 
}
