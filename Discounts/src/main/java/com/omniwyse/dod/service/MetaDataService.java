package com.omniwyse.dod.service;

import java.util.List;

import com.omniwyse.dod.DTO.CategoryBrandVO;
import com.omniwyse.dod.DTO.LocationVO;
import com.omniwyse.dod.DTO.MerchantPromotionBeaconVO;
import com.omniwyse.dod.DTO.NewProductVO;
import com.omniwyse.dod.DTO.ProductVO;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.Location;
import com.omniwyse.dod.model.MerchantPromotionBeacon;
import com.omniwyse.dod.model.Product;

public interface MetaDataService {

	public List<Category> fetchCategories();

	public List<CategoryBrandVO> fetchBrands();
	
	public List<ProductVO> fetchMerchantProducts(ProductVO productVO);
	
	public Product createProduct(NewProductVO newProductVO) ; 
	
	public Location createLocation(LocationVO locationVO);
	
	public List validateMPBCreation(MerchantPromotionBeaconVO merchantPromotionBeaconVO);
	
	public MerchantPromotionBeacon createMerchantPromotionBeacon(List merchantPromotionBeaconVO);
	

}
