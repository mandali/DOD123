package com.omniwyse.dod.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.DTO.NewProductVO;
import com.omniwyse.dod.dao.MerchantDao;
import com.omniwyse.dod.dao.ProductDao;
import com.omniwyse.dod.model.GetMerchantById;
import com.omniwyse.dod.model.GetMerchatProfile;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.MerchantPromotions;
import com.omniwyse.dod.model.Product;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.service.MerchantService;
@Service
@Transactional
public class MerchantServiceImpl implements MerchantService{
	
	@Autowired
	MerchantDao MerchantDao;
	
	@Autowired
	ProductDao productDao;
	
		
	
	public MerchantProfile registerMerchant(MerchantProfile merchantProfile) {
		Date date=new Date();
		merchantProfile.setCreateddate(date);
		MerchantProfile resp=MerchantDao.registermerchant(merchantProfile);
		return resp;		
	}
		
	public MerchantProfile getMerchantMobile(GetMerchantById getMerchantById) {
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

	public MerchantProfile getMerchant(MerchantLogin MerchantLogin) {
		
		return MerchantDao.getMerchant(MerchantLogin);
	}

	public MerchantProfile validatePromotion(CreatePromotionVo createPromotionVo) {
		
		return MerchantDao.validatePromotion(createPromotionVo);
	}

	public MerchantProfile validateProduct(NewProductVO newProductVO) {
		
		return productDao.validateProduct(newProductVO);
	}

	public Product validateProductname(NewProductVO productVO) {
		
		return productDao.validateProductname(productVO);
	}
		
	
	}


