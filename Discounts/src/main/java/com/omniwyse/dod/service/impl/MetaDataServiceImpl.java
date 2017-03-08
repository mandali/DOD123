package com.omniwyse.dod.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.DTO.CategoryBrandVO;
import com.omniwyse.dod.DTO.LocationVO;
import com.omniwyse.dod.DTO.MerchantPromotionBeaconVO;
import com.omniwyse.dod.DTO.NewProductVO;
import com.omniwyse.dod.DTO.ProductVO;
import com.omniwyse.dod.dao.MetaDataDao;
import com.omniwyse.dod.dao.ProductDao;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.Location;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.MerchantPromotionBeacon;
import com.omniwyse.dod.model.Product;
import com.omniwyse.dod.service.MetaDataService;

@Service
@Transactional
public class MetaDataServiceImpl implements MetaDataService {

	@Autowired
	MetaDataDao metaDataDao;
	@Autowired
	ProductDao productDao;

	public List<Category> fetchCategories() {
		return metaDataDao.fetchCategories();
	}
	public List<CategoryBrandVO> fetchBrands() {
		return metaDataDao.fetchBrands();
	}
	public List<ProductVO> fetchMerchantProducts(ProductVO productVO) {
		
		return metaDataDao.fetchMerchantProducts(productVO);
	}
	public Product createProduct(NewProductVO newProductVO,MerchantProfile merchantProfile) {
		// TODO Auto-generated method stub
		return productDao.createProduct(newProductVO,merchantProfile);

	}

	public Location createLocation(LocationVO locationVO) {	
		return metaDataDao.createLocation(locationVO);
	}
	@SuppressWarnings("rawtypes")
	public List validateMPBCreation(MerchantPromotionBeaconVO merchantPromotionBeaconVO) {		
		return metaDataDao.validateMPBCreation(merchantPromotionBeaconVO);
	}
	@SuppressWarnings("rawtypes")
	public MerchantPromotionBeacon createMerchantPromotionBeacon(List merchantPromotionBeaconVO) {
		
		return metaDataDao.createMerchantPromotionBeacon(merchantPromotionBeaconVO);
	}

}
