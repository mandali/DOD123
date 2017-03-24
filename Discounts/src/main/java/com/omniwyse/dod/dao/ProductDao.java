package com.omniwyse.dod.dao;

import com.omniwyse.dod.DTO.NewProductVO;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.Product;

public interface ProductDao {
	
	public Product createProduct(NewProductVO newProductVO,MerchantProfile merchantProfile);
	
	public MerchantProfile validateProduct(NewProductVO newProductVO);
	
	public Product validateProductname(NewProductVO productVO);
	
	public Product fetchProduct(Long id);

}
