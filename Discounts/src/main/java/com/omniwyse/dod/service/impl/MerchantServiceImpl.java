package com.omniwyse.dod.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.dao.MerchantDao;
import com.omniwyse.dod.model.GetMerchantById;
import com.omniwyse.dod.model.GetMerchatProfile;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.MerchantPromotions;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.service.MerchantService;
@Service
@Transactional
public class MerchantServiceImpl implements MerchantService{
	
	@Autowired
	MerchantDao MerchantDao;
	
		
	
	public MerchantProfile registermerchant(MerchantProfile merchantProfile) {
		Date date=new Date();
		merchantProfile.setCreateddate(date);
		MerchantProfile resp=MerchantDao.registermerchant(merchantProfile);
		return resp;		
	}
		
	public MerchantProfile getmerchantMobile(GetMerchantById getMerchantById) {
		MerchantProfile resp=MerchantDao.getMerchatByMobile(getMerchantById);
		return resp;
	}
		

	public MerchantProfile merchatLogin(MerchantLogin merchantLogin) {		
			
			return MerchantDao.merchantLogin(merchantLogin);
		}
		
	
	public MerchantProfile merchatAutheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail) {
		
		return MerchantDao.merchantautheticateWithEmail(merchantLoginwithEmail);
	}
		
	public MerchantProfile merchatAutheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile) {
		
		return MerchantDao.merchantautheticateWithMobile(merchantLoginwithMobile);
	}
		
	public MerchantProfile merchatProfile(GetMerchatProfile getMerchatProfile) {
		
		return MerchantDao.merchantProfile(getMerchatProfile);
	}
		
	public List<MerchantProfile> allMerchants() {
		
		return MerchantDao.allMerchants();
	}
		
	public MerchantProfile getMerchatByID(Integer id) {
		
		return MerchantDao.getMerchantbyID(id);
	}
		
	public List<Promotion> merchatPromotion(MerchantPromotions MerchantPromotions, Date date) {
		
		 return MerchantDao.merchantPromotions(MerchantPromotions, date);
	}
		
	
	}


