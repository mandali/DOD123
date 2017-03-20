package com.omniwyse.dod.service;

import java.util.Date;
import java.util.List;

import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.DTO.NewProductVO;
import com.omniwyse.dod.model.GetMerchantById;
import com.omniwyse.dod.model.GetMerchatProfile;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.MerchantPromotions;
import com.omniwyse.dod.model.Product;
import com.omniwyse.dod.model.Promotion;

public interface MerchantService {
	
	public MerchantProfile registermerchant(MerchantProfile merchantProfile); 
	
	public MerchantProfile getmerchantMobile(GetMerchantById getMerchantById);
	
	public MerchantProfile getMerchant(MerchantLogin MerchantLogin);
	
	public MerchantProfile merchatLogin(MerchantLogin merchantLogin);
	
    public MerchantProfile merchatAutheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail);
	
	public MerchantProfile merchatAutheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile); 
	
	public MerchantProfile merchatProfile(GetMerchatProfile GetMerchatProfile); 
	
	public MerchantProfile validatePromotion(CreatePromotionVo createPromotionVo);
	
	public MerchantProfile validateProduct(NewProductVO newProductVO);
	
	public Product validateProductname(NewProductVO productVO);
	
	public List<MerchantProfile> allMerchants();
	
	public List<Promotion> merchatPromotion(MerchantPromotions MerchantPromotions , Date date);

}
