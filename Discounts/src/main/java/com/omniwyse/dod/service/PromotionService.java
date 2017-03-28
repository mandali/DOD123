package com.omniwyse.dod.service;

import java.util.Date;
import java.util.List;

import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.DTO.PromotionDto;
import com.omniwyse.dod.model.Brand;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.Product;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.PromotionSummary;

public interface PromotionService {
	
    
	public List<Promotion> getPromotions();
	
	public List<Promotion> getCategoryPromotions(Date currentdate ,CategorySelection categorySelection);
	
	public Promotion createPromotions(CreatePromotionVo createPromotionVo); 
	
	public Category getcategoryId(CreatePromotionVo createPromotionVo); 
	
	public Brand getBrandId(CreatePromotionVo createPromotionVo);
	
	public Product fetchProductById(CreatePromotionVo createPromotionVo);
	
	public Promotion idBasePromotions(Integer promotionId); 
	
	public List<PromotionSummary> promotionSummary( String date ); 
	
	public List<PromotionDto> categoryIdPromotions(Long categoryId); 
	
	public List<PromotionDto> brandIdPromotions(Long brandId);
	
	public List<PromotionDto> brandCatIdPromotion(Long categoryId, Long brandId);
	
	public boolean updatePromotion(Long id,CreatePromotionVo createPromotionVo);
	
	public boolean deletePromotion(Long id);
	
	

}
