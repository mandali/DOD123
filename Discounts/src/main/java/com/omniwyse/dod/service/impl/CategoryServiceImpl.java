package com.omniwyse.dod.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.dao.CategoryDao;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.service.CategoryService;



@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDao categoryDao;

	public Category fetchCategory(Long id) {
		
		return categoryDao.fetchCategory(id);
	}

}
