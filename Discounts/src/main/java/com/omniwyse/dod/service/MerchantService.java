package com.omniwyse.dod.service;

import com.omniwyse.dod.model.GetMerchantById;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;

public interface MerchantService {
	
	public MerchantProfile registermerchant(MerchantProfile merchantProfile); 
	
	public MerchantProfile GetmerchantMobile(GetMerchantById getMerchantById);
	
	public MerchantProfile MerchatLogin(MerchantLogin merchantLogin);
	
    public MerchantProfile merchatAutheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail);
	
	public MerchantProfile merchatAutheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile);

}
