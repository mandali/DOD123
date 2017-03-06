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
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.Promotionsummary;
import com.omniwyse.dod.service.PromotionService;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService{
	
	@Autowired
	PromotionsDao promotionsDao;
	
	@Autowired
	MerchantDao merchantDao;
	
	

	@SuppressWarnings("rawtypes")
	public List getPromotions() {
		
		return promotionsDao.getPromotions();
	}
	
	/*===========================================================================================================*/	

	public List<Promotion> getCategoryPromotions(Date currentdate, CategorySelection categorySelection) {
		
		return promotionsDao.getCategoryPromotions(currentdate, categorySelection);
	}
	
	/*===========================================================================================================*/	

	public Promotion CreatePromotions(CreatePromotionVo createPromotionVo) {
		Date date=new Date();
		createPromotionVo.setCreateddate(date);
		createPromotionVo.setStartdate(date);
		createPromotionVo.setEnddate(date);				
		return promotionsDao.CreatePromotions(createPromotionVo);
	}
	
	/*===========================================================================================================*/	
	
	@SuppressWarnings("unused")
	public Promotion CreatePromotions(PromotionDto promotionDto) {		
		Date date=new Date();
		Promotion promotion=new Promotion();
		MerchantProfile merchantProfile=merchantDao.getMerchantbyID(promotionDto.getMerchatId());			
		promotion.setOriginalPrice(promotionDto.getOriginalPrice());
		promotion.setDiscount(promotionDto.getDiscount());
		promotion.setStartdate(date);
		promotion.setEnddate(date);
		promotion.setDescription(promotionDto.getDescription());
		promotion.setProduct_image(promotionDto.getProduct_image());
		promotion.setLocation(promotionDto.getLocation());		
		promotion.setCreateddate(date);
		promotion.setProduct_id(promotionDto.getProduct_id());
		promotion.setMerchatid(promotionDto.getMerchatId());		
		return promotion;
	}
	
	/*===========================================================================================================*/	

	public Promotion IdBasePromotions(IdBasePromotion idBasePromotion) {
		
		return promotionsDao.getIdbasePromotion(idBasePromotion);
	}
	
	/*===========================================================================================================*/	

	public List<Promotionsummary> promotionSummary(String date) {
		Date date1=new Date();
		return promotionsDao.PromotionSummary(date1);
	}
	
	/*===========================================================================================================*/	

	public List<PromotionDto> CategoryIdPromotions(CategoryPromotion categoryPromotion) {
		
		return promotionsDao.CategoryIdPromotion(categoryPromotion);
		
	}
	
	/*===========================================================================================================*/	

	public List<PromotionDto> brandIdPromotions(CategoryPromotion categoryPromotion) {
		
		return promotionsDao.brandIdPromotion(categoryPromotion);
	}
	
	/*===========================================================================================================*/	

	public List<PromotionDto> brandCatIdPromotion(CategoryPromotion categoryPromotion) {
		
		return promotionsDao.brandCatIdPromotion(categoryPromotion);
	}
	
	/*===========================================================================================================*/	

}
