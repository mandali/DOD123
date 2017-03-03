package com.omniwyse.dod.service;

import java.util.Date;
import java.util.List;

import com.omniwyse.dod.model.GetMerchantById;
import com.omniwyse.dod.model.GetMerchatProfile;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.MerchantPromotions;
import com.omniwyse.dod.model.Promotion;

public interface MerchantService {
	
	public MerchantProfile registermerchant(MerchantProfile merchantProfile); 
	
	public MerchantProfile GetmerchantMobile(GetMerchantById getMerchantById);
	
	public MerchantProfile MerchatLogin(MerchantLogin merchantLogin);
	
    public MerchantProfile merchatAutheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail);
	
	public MerchantProfile merchatAutheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile); 
	
	public MerchantProfile MerchatProfile(GetMerchatProfile GetMerchatProfile); //MerchantPromotions
	
	public List<MerchantProfile> AllMerchants();
	
	public List<Promotion> MerchatPromotion(MerchantPromotions MerchantPromotions , Date date);

}
