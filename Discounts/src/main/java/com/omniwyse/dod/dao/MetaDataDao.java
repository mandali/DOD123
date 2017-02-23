package com.omniwyse.dod.dao;

import java.util.List;

import com.omniwyse.dod.DTO.CategoryBrandVO;
import com.omniwyse.dod.model.Category;

public interface MetaDataDao {
	
	public List<Category> fetchCategories();

	public List<CategoryBrandVO> fetchBrands();
}
