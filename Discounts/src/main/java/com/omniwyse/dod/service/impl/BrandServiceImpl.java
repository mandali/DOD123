package com.omniwyse.dod.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.dao.BrandDao;
import com.omniwyse.dod.model.Brand;
import com.omniwyse.dod.service.BrandService;
@Service
@Transactional
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	BrandDao brandDao;

	public Brand fetchBrand(Long id) {
		
		return brandDao.fetchBrand(id);
	}

}
