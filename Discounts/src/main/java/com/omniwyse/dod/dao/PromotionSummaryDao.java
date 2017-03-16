package com.omniwyse.dod.dao;

import java.util.List;

import com.omniwyse.dod.model.Brand;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.PromotionSummary;

public interface PromotionSummaryDao {
	
	public List<Object[]> fetchPromotionData();
	
	public Brand fetchBrandID(Integer brandId);
	
	public Category fetchCategoryID(Integer categoryId);
	
	public boolean insertPromotions(List<PromotionSummary> list);
	
	

}
