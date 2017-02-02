package com.omni.dod.service;

import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantLogin;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.ConsumerLogin;

public interface LoginService {
	
	public ConsumerProfile autheticate(ConsumerLogin userLogin);   
	
	public MerchantProfile merchatAutheticate(MerchantLogin merchantLogin);

}
