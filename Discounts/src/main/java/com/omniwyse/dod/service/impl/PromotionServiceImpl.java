package com.omniwyse.dod.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.DTO.CategoryPromotion;
import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.DTO.PromotionDto;
import com.omniwyse.dod.dao.MerchantDao;
import com.omniwyse.dod.dao.PromotionsDao;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.IdBasePromotion;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.PromotionSummary;
import com.omniwyse.dod.service.PromotionService;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService{
	
	@Autowired
	PromotionsDao promotionsDao;
	
	@Autowired
	MerchantDao merchantDao;
	
	

	
	public List<Promotion> getPromotions() {
		
		return promotionsDao.getPromotions();
	}

	public List<Promotion> getCategoryPromotions(Date currentdate, CategorySelection categorySelection) {
		
		return promotionsDao.getCategoryPromotions(currentdate, categorySelection);
	}
	public Promotion createPromotions(CreatePromotionVo createPromotionVo) {
		Date date=new Date();
		createPromotionVo.setCreateddate(date);
		createPromotionVo.setStartdate(date);
		createPromotionVo.setEnddate(date);				
		return promotionsDao.createPromotions(createPromotionVo);
	}		

	public Promotion idBasePromotions(IdBasePromotion idBasePromotion) {
		
		return promotionsDao.getIdbasePromotion(idBasePromotion);
	}	

	public List<PromotionSummary> promotionSummary(String date) {
		Date date1=new Date();
		return promotionsDao.promotionSummary(date1);
	}	

	public List<PromotionDto> categoryIdPromotions(CategoryPromotion categoryPromotion) {
		
		return promotionsDao.categoryIdPromotion(categoryPromotion);
		
	}	

	public List<PromotionDto> brandIdPromotions(CategoryPromotion categoryPromotion) {
		
		return promotionsDao.brandIdPromotion(categoryPromotion);
	}	

	public List<PromotionDto> brandCatIdPromotion(CategoryPromotion categoryPromotion) {
		
		return promotionsDao.brandCatIdPromotion(categoryPromotion);
	}	

}
