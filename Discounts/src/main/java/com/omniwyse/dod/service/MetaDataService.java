package com.omniwyse.dod.service;

import java.util.List;

import com.omniwyse.dod.DTO.CategoryBrandVO;
import com.omniwyse.dod.DTO.ProductVO;
import com.omniwyse.dod.model.Category;

public interface MetaDataService {

	public List<Category> fetchCategories();

	public List<CategoryBrandVO> fetchBrands();
	
	public List<ProductVO> fetchMerchantProducts(ProductVO productVO);

}
