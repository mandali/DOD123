package com.omniwyse.dod.dao;

import java.util.List;

import com.omniwyse.dod.DTO.CategoryBrandVO;
import com.omniwyse.dod.DTO.LocationVO;
import com.omniwyse.dod.DTO.MerchantPromotionBeaconSearchVo;
import com.omniwyse.dod.DTO.MerchantPromotionBeaconVO;
import com.omniwyse.dod.DTO.ProductVO;
import com.omniwyse.dod.model.Beacon;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.Location;
import com.omniwyse.dod.model.MerchantPromotionBeacon;

public interface MetaDataDao {
	
	public List<Category> fetchCategories();

	public List<CategoryBrandVO> fetchBrands();
	
	public List<ProductVO> fetchMerchantProducts(ProductVO productVO); 
	
	public Location createLocation(LocationVO locationVo) ;
		
	@SuppressWarnings("rawtypes")
	public List validateMPBCreation(MerchantPromotionBeaconVO merchantPromotionBeaconVO);
	
	public List<Object> fetchMPBObjects(MerchantPromotionBeaconSearchVo merchantPromotionBeaconSearchVo);
	
	@SuppressWarnings("rawtypes")
	public MerchantPromotionBeacon createMerchantPromotionBeacon(List merchantPromotionBeaconVO);
	
	public List<Object[]> fetchNoBeaconPromotions();
	
	public List<Beacon> fetchBeacons();
	
	
}
