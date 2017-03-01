package com.omniwyse.dod.dao;

import java.util.List;

import com.omniwyse.dod.DTO.CategoryBrandVO;
import com.omniwyse.dod.DTO.ProductVO;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.MerchantProfile;

public interface MetaDataDao {
	
	public List<Category> fetchCategories();

	public List<CategoryBrandVO> fetchBrands();
	
	public List<ProductVO> fetchMerchantProducts(ProductVO productVO);
}
