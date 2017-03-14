package com.omniwyse.dod.scheduler;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;

import com.omniwyse.dod.bean.DataResult;
import com.omniwyse.dod.bean.DataResultEntity;
import com.omniwyse.dod.dao.PromotionSummaryDao;
import com.omniwyse.dod.model.Brand;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.PromotionSummary;
import com.omniwyse.dod.service.PromotionSummaryService;

public class PromotionScheduler  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(PromotionScheduler.class);
	
	@Autowired
	PromotionSummaryService promotionSummaryService;
	
	@Autowired 
	PromotionSummaryDao promotionSummaryDao;

	@SuppressWarnings({ "rawtypes", "unused" })
	@Scheduled(fixedDelay=3600)
	public void startPromotionScheduler(){
		System.out.println("In startPromotionScheduler");
		List<Object[]> promotions;
		PromotionSummary promotionSummary;
		List<PromotionSummary> promotionSummaries=new ArrayList<PromotionSummary>();
		final String METHOD_NAME = "startPromotionScheduler";
		try{
		promotions=promotionSummaryService.fetchPromotionData();		
		Iterator iterator = promotions.iterator();
		
		 Calendar calendar = Calendar.getInstance();
		    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());

		if(!promotions.isEmpty()){
			while (iterator.hasNext()) {				
				Object[] objects=(Object[]) iterator.next();
				String maxDiscount=(String) objects[0];				
				String minDiscount=(String) objects[1];				
				BigInteger count=(BigInteger) objects[2];				
				Integer brandId=(Integer) objects[3];
				Integer categoryId=(Integer) objects[4];
				promotionSummary=new PromotionSummary();
				promotionSummary.setMaxDiscount(Integer.valueOf(maxDiscount));
				promotionSummary.setMinDiscount(Integer.valueOf(minDiscount));
				promotionSummary.setCount(count.intValue());
				
				promotionSummary.setCreateddate(ourJavaTimestampObject);
				Brand brand=promotionSummaryDao.fetchBrandID(brandId);				
				if(brand!=null){
					promotionSummary.setBrandId(brand);
				}
				Category categoryID=promotionSummaryDao.fetchCategoryID(categoryId);
				if(categoryID!=null)
				{
					promotionSummary.setCategoryID(categoryID);
				}
				promotionSummaries.add(promotionSummary);
			}		
		}
		
		if(promotionSummaries!=null && !promotionSummaries.isEmpty()){
			boolean b=promotionSummaryService.insertPromotions(promotionSummaries);	
			if(b){
				DataResult dataResult=new DataResult(true, " posted successfully ... " , HttpStatus.OK.value());
			}else{
				DataResult dataResult=new DataResult(false, " some problem ", HttpStatus.OK.value());				
			}
		}
		
	}catch(Exception exception){
	logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
	}
			
}
		
	

}
