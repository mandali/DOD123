package com.omniwyse.dod.dao;

import com.omniwyse.dod.DTO.NewProductVO;
import com.omniwyse.dod.model.Product;

public interface ProductDao {
	
	public Product createProduct(NewProductVO newProductVO);

}
