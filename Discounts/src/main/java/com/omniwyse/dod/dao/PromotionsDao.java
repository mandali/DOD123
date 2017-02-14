package com.omniwyse.dod.dao;

import java.util.Date;
import java.util.List;

import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.IdBasePromotion;
import com.omniwyse.dod.model.Promotion;

public interface PromotionsDao {
	
public List<Promotion> getPromotions(Date currentdate); 
	
	public List<Promotion> getCategoryPromotions(Date currentdate, CategorySelection categorySelection);
	
	public Promotion CreatePromotions(Promotion promotion); 
	
	public Promotion getIdbasePromotion(IdBasePromotion idBasePromotion);

}
