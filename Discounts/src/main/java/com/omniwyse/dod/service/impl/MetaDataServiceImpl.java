package com.omniwyse.dod.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.DTO.CategoryBrandVO;
import com.omniwyse.dod.DTO.ProductVO;
import com.omniwyse.dod.dao.MetaDataDao;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.service.MetaDataService;

@Service
@Transactional
public class MetaDataServiceImpl implements MetaDataService {

	@Autowired
	MetaDataDao metaDataDao;

	public List<Category> fetchCategories() {
		return metaDataDao.fetchCategories();
	}

	public List<CategoryBrandVO> fetchBrands() {
		return metaDataDao.fetchBrands();
	}

	public List<ProductVO> fetchMerchantProducts(ProductVO productVO) {
		// TODO Auto-generated method stub
		return metaDataDao.fetchMerchantProducts(productVO);
	}

}
