package com.omniwyse.dod.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.dao.PromotionSummaryDao;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.PromotionSummary;
import com.omniwyse.dod.service.PromotionSummaryService;

@Service
@Transactional
public class PromotionSummaryServiceImpl implements PromotionSummaryService{
	@Autowired
	PromotionSummaryDao promotionSummaryDao;

	public List<Object[]> fetchPromotionData() {
		
		return promotionSummaryDao.fetchPromotionData();
	}

	public PromotionSummary insertPromotion(PromotionSummary promotionSummary) {
		
		return promotionSummaryDao.insertPromotion(promotionSummary);
	}

	public boolean insertPromotions(List<PromotionSummary> list) {
		
		return promotionSummaryDao.insertPromotions(list);
	}

}
