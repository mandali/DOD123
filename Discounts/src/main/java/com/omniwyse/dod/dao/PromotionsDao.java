package com.omniwyse.dod.dao;

import java.util.Date;
import java.util.List;

import com.omniwyse.dod.DTO.CategoryPromotion;
import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.DTO.PromotionDto;
import com.omniwyse.dod.model.Brand;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.IdBasePromotion;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.Promotionsummary;

public interface PromotionsDao {
	
public List<Promotion> getPromotions(); 
	
	public List<Promotion> getCategoryPromotions(Date currentdate, CategorySelection categorySelection);
	
	public Promotion CreatePromotions(CreatePromotionVo createPromotionVo); 
	
	public Promotion getIdbasePromotion(IdBasePromotion idBasePromotion);

	public List<Promotionsummary> PromotionSummary(Date date);
	
	public Category getcategoryId(CreatePromotionVo createPromotionVo); 
	
	public Brand getBrandId(CreatePromotionVo createPromotionVo);	
	
	public List<PromotionDto> CategoryIdPromotion(CategoryPromotion categoryPromotion );
	
	public List<PromotionDto> brandIdPromotion(CategoryPromotion categoryPromotion );
	
	public List<PromotionDto> brandCatIdPromotion(CategoryPromotion categoryPromotion );
	
	
	
}
