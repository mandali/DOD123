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
import com.omniwyse.dod.model.Product;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.PromotionSummary;

public interface PromotionsDao {
	
public List<Promotion> getPromotions(); 
	
	public List<Promotion> getCategoryPromotions(Date currentdate, CategorySelection categorySelection);
	
	public Promotion createPromotions(CreatePromotionVo createPromotionVo); 
	
	public Promotion getIdbasePromotion(IdBasePromotion idBasePromotion);

	public List<PromotionSummary> promotionSummary(Date date);
	
	public Category getcategoryId(CreatePromotionVo createPromotionVo); 
	
	public Brand getBrandId(CreatePromotionVo createPromotionVo);
	
	public Product fetchProductById(CreatePromotionVo createPromotionVo);	
	
	public List<PromotionDto> categoryIdPromotion(CategoryPromotion categoryPromotion );
	
	public List<PromotionDto> brandIdPromotion(CategoryPromotion categoryPromotion );
	
	public List<PromotionDto> brandCatIdPromotion(CategoryPromotion categoryPromotion );
	
	public boolean updatePromotions(Long id,CreatePromotionVo createPromotionVo);
	
	public boolean deletePromotions(Long id); 
	
	
	
}
