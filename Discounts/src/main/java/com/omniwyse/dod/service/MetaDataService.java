package com.omniwyse.dod.service;

import java.util.List;

import com.omniwyse.dod.DTO.CategoryBrandVO;
import com.omniwyse.dod.DTO.LocationVO;
import com.omniwyse.dod.DTO.MerchantPromotionBeaconVO;
import com.omniwyse.dod.DTO.NewProductVO;
import com.omniwyse.dod.DTO.ProductVO;
import com.omniwyse.dod.model.Beacon;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.Location;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.MerchantPromotionBeacon;
import com.omniwyse.dod.model.Product;

public interface MetaDataService {

	public List<Category> fetchCategories();

	public List<CategoryBrandVO> fetchBrands();
	
	public List<ProductVO> fetchMerchantProducts(ProductVO productVO);
	
	public Product createProduct(NewProductVO newProductVO,MerchantProfile merchantProfile) ; 
	
	public Location createLocation(LocationVO locationVO);
	
	@SuppressWarnings("rawtypes")
	public List validateMPBCreation(MerchantPromotionBeaconVO merchantPromotionBeaconVO);
	
	@SuppressWarnings("rawtypes")
	public MerchantPromotionBeacon createMerchantPromotionBeacon(List merchantPromotionBeaconVO);
	
	public List<Beacon> fetchBeacons();
	

}
