package com.omniwyse.dod.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.dao.ProductDao;
import com.omniwyse.dod.model.Product;
import com.omniwyse.dod.service.ProductService;

@Service
@Transactional
public class ProductServiceImple implements ProductService{
	
	@Autowired
	ProductDao productDao;

	public Product fetchProduct(Long id) {
		
		return productDao.fetchProduct(id);
	}

}
