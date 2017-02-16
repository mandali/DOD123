package com.omniwyse.dod.dao;

import com.omniwyse.dod.model.GetMerchantById;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;

public interface MerchantDao {
	
	public MerchantProfile registermerchant(MerchantProfile merchantProfile);
	
	public MerchantProfile GetMerchatByMobile(GetMerchantById getMerchantById);
	
	public MerchantProfile GetMerchant(MerchantLogin MerchantLogin);
	
	public MerchantProfile MerchantLogin(MerchantLogin merchantLogin);
	
    public MerchantProfile merchantautheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail); 
	
	public MerchantProfile merchantautheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile);

}
