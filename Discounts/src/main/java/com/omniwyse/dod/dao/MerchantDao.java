package com.omniwyse.dod.dao;

import java.util.List;

import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.DTO.MerchantProfileVo;
import com.omniwyse.dod.model.GetMerchantById;
import com.omniwyse.dod.model.GetMerchatProfile;
import com.omniwyse.dod.model.Location;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.Promotion;

public interface MerchantDao {
	
	public MerchantProfile registermerchant(MerchantProfile merchantProfile);
	
	public MerchantProfile getMerchatByMobile(GetMerchantById getMerchantById);
	
	public MerchantProfile getMerchant(MerchantLogin MerchantLogin);
	
	public MerchantProfile merchantLogin(MerchantLogin merchantLogin);
	
    public MerchantProfile merchantautheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail); 
	
	public MerchantProfile merchantautheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile); 

	public MerchantProfile merchantProfile(GetMerchatProfile getMerchatProfile);
	
	public List<MerchantProfile> allMerchants();  
	
	public MerchantProfile getMerchantbyID(Integer id);
	
	public List<Promotion> merchantPromotions(Integer merchantId); 	
	
	public MerchantProfile validatePromotion(CreatePromotionVo createPromotionVo);
	
	public Location fetchLocationById(Long locationId); 
	
	public boolean updateMerchant(Long id ,MerchantProfileVo merchantProfileVo );
	
	public boolean deleteMerchant(Long id);
}
