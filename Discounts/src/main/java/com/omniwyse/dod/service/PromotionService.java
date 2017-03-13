package com.omniwyse.dod.service;

import java.util.Date;
import java.util.List;

import com.omniwyse.dod.DTO.CategoryPromotion;
import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.DTO.PromotionDto;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.IdBasePromotion;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.PromotionSummary;

public interface PromotionService {
	
    
	public List<Promotion> getPromotions();
	
	public List<Promotion> getCategoryPromotions(Date currentdate ,CategorySelection categorySelection);
	
	public Promotion createPromotions(CreatePromotionVo createPromotionVo); 	 
	
	public Promotion idBasePromotions(IdBasePromotion idBasePromotion); 
	
	public List<PromotionSummary> promotionSummary( String date ); 
	
	public List<PromotionDto> categoryIdPromotions(CategoryPromotion categoryPromotion); 
	
	public List<PromotionDto> brandIdPromotions(CategoryPromotion categoryPromotion);
	
	public List<PromotionDto> brandCatIdPromotion(CategoryPromotion categoryPromotion);
	
	

}
