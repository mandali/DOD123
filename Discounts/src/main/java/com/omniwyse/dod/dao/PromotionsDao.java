package com.omniwyse.dod.dao;

import java.util.Date;
import java.util.List;

import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.IdBasePromotion;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.Promotionsummery;

public interface PromotionsDao {
	
public List<Promotion> getPromotions(Date currentdate); 
	
	public List<Promotion> getCategoryPromotions(Date currentdate, CategorySelection categorySelection);
	
	public Promotion CreatePromotions(CreatePromotionVo createPromotionVo); //
	
	public Promotion getIdbasePromotion(IdBasePromotion idBasePromotion);

	public List<Promotionsummery> PromotionSummary(Date date);
}
