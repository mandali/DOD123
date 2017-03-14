package com.omniwyse.dod.service;

import java.util.List;

import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.PromotionSummary;

public interface PromotionSummaryService {
	
	public List<Object[]> fetchPromotionData();
	
	public PromotionSummary insertPromotion(PromotionSummary promotionSummary);
	
	public boolean insertPromotions(List<PromotionSummary> list);
	
	

}
