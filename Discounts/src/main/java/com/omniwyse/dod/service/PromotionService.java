package com.omniwyse.dod.service;

import java.util.Date;
import java.util.List;

import com.omniwyse.dod.DTO.CategoryPromotion;
import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.DTO.PromotionDto;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.IdBasePromotion;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.Promotionsummary;

public interface PromotionService {
	
    public List getPromotions();
	
	public List<Promotion> getCategoryPromotions(Date currentdate ,CategorySelection categorySelection);
	
	public Promotion CreatePromotions(CreatePromotionVo createPromotionVo); 
	
	public Promotion CreatePromotions(PromotionDto promotionDto); 
	
	public Promotion IdBasePromotions(IdBasePromotion idBasePromotion); 
	
	public List<Promotionsummary> promotionSummary( String date ); 
	
	public Promotion CategoryIdPromotions(CategoryPromotion categoryPromotion);
	
	public List<Promotion> brandIdPromotions(CategoryPromotion categoryPromotion);
	
	

}
