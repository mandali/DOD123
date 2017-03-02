package com.omniwyse.dod.dao;

import java.util.List;

import com.omniwyse.dod.DTO.NewProductVO;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.Product;

public interface ProductDao {
	
	public Product createProduct(NewProductVO newProductVO);
	
	public MerchantProfile validateProduct(NewProductVO newProductVO);
	
	public List<Product> validateProductname(NewProductVO productVO);

}
