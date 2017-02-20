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
	public MerchantProfile GetmerchantMobile(GetMerchantById getMerchantById) {
		MerchantProfile resp=MerchantDao.GetMerchatByMobile(getMerchantById);
		return resp;
	}

	public MerchantProfile MerchatLogin(MerchantLogin merchantLogin) {		
			
			return MerchantDao.MerchantLogin(merchantLogin);
		}
	
	public MerchantProfile merchatAutheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail) {
		
		return MerchantDao.merchantautheticateWithEmail(merchantLoginwithEmail);
	}
	public MerchantProfile merchatAutheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile) {
		
		return MerchantDao.merchantautheticateWithMobile(merchantLoginwithMobile);
	}
	public MerchantProfile MerchatProfile(GetMerchatProfile getMerchatProfile) {
		
		return MerchantDao.MerchantProfile(getMerchatProfile);
	}
	public List<MerchantProfile> AllMerchants() {
		
		return MerchantDao.AllMerchants();
	}
	public MerchantProfile getMerchatByID(Integer id) {
		
		return MerchantDao.getMerchantbyID(id);
	}
	public List<MerchantProfile> MerchatPromotion(MerchantPromotions MerchantPromotions, Date date) {
		
		 return MerchantDao.MerchantPromotions(MerchantPromotions, date);
	}
	
	}


