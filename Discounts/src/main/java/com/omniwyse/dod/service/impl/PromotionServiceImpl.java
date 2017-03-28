package com.omniwyse.dod.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.DTO.PromotionDto;
import com.omniwyse.dod.dao.MerchantDao;
import com.omniwyse.dod.dao.PromotionsDao;
import com.omniwyse.dod.model.Brand;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.Product;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.PromotionSummary;
import com.omniwyse.dod.service.PromotionService;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService{
	
	@Autowired
	PromotionsDao promotionsDao;
	
	@Autowired
	MerchantDao merchantDao;
	
	

	
	public List<Promotion> getPromotions() {
		
		return promotionsDao.getPromotions();
	}

	public List<Promotion> getCategoryPromotions(Date currentdate, CategorySelection categorySelection) {
		
		return promotionsDao.getCategoryPromotions(currentdate, categorySelection);
	}
	public Promotion createPromotions(CreatePromotionVo createPromotionVo) {
		Date date=new Date();
		createPromotionVo.setCreateddate(date);
		createPromotionVo.setStartdate(date);
		createPromotionVo.setEnddate(date);				
		return promotionsDao.createPromotions(createPromotionVo);
	}		

	public Promotion idBasePromotions(Integer promotionId) {
		
		return promotionsDao.getIdbasePromotion(promotionId);
	}	

	public List<PromotionSummary> promotionSummary(String date) {
		Date date1=new Date();
		return promotionsDao.promotionSummary(date1);
	}	

	public List<PromotionDto> categoryIdPromotions(Long categoryId) {
		
		return promotionsDao.categoryIdPromotion(categoryId);
		
	}	

	public List<PromotionDto> brandIdPromotions(Long brandId) {
		
		return promotionsDao.brandIdPromotion(brandId);
	}	

	public List<PromotionDto> brandCatIdPromotion(Long categoryId, Long brandId) {
		
		return promotionsDao.brandCatIdPromotion(categoryId, brandId);
	}

	public Category getcategoryId(CreatePromotionVo createPromotionVo) {
		
		return promotionsDao.getcategoryId(createPromotionVo);
	}

	public Brand getBrandId(CreatePromotionVo createPromotionVo) {
		
		return promotionsDao.getBrandId(createPromotionVo);
	}

	public Product fetchProductById(CreatePromotionVo createPromotionVo) {
		
		return promotionsDao.fetchProductById(createPromotionVo);
	}

	public boolean updatePromotion(Long id,CreatePromotionVo createPromotionVo) {
		
		return promotionsDao.updatePromotions(id,createPromotionVo);
	}

	public boolean deletePromotion(Long id) {
		
		return promotionsDao.deletePromotions(id);
	}	

}
