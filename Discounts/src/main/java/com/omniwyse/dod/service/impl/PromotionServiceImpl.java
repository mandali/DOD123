package com.omniwyse.dod.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.dao.PromotionsDao;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.IdBasePromotion;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.service.PromotionService;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService{
	
	@Autowired
	PromotionsDao promotionsDao;

	public List<Promotion> getPromotions(Date currentdate) {
		
		return promotionsDao.getPromotions(currentdate);
	}

	public List<Promotion> getCategoryPromotions(Date currentdate, CategorySelection categorySelection) {
		
		return promotionsDao.getCategoryPromotions(currentdate, categorySelection);
	}

	public Promotion CreatePromotions(Promotion promotion) {
		
		return promotionsDao.CreatePromotions(promotion) ;
	}

	public Promotion IdBasePromotions(IdBasePromotion idBasePromotion) {
		
		return promotionsDao.getIdbasePromotion(idBasePromotion);
	}

}
