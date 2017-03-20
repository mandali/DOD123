package com.omniwyse.dod.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.dao.PromotionSummaryDao;
import com.omniwyse.dod.model.Brand;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.PromotionSummary;
import com.omniwyse.dod.model.RegisterWithOtp;

@Repository
public class PromotionSummaryDaoImpl implements PromotionSummaryDao{
	
	private static final Logger logger = Logger.getLogger(PromotionSummaryDaoImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Object[]> fetchPromotionData() {		
		List<Object[]> promotions=null;
		final String METHOD_NAME = "fetchPromotionData";
		try{
			Session session = this.sessionFactory.getCurrentSession();
			promotions = session.createSQLQuery("select max(p.DISCOUNT),min(p.DISCOUNT),count(p.DISCOUNT),p.BRD_ID , p.CAT_ID from promotions p group by p.BRD_ID").list();			
		}catch(Exception exception)
		{			
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());			
		}		
		return promotions;
	}	

	public Brand fetchBrandID(Integer brandId) {
		
		long brandIds=brandId.longValue();		
		final String METHOD_NAME = "fetchBrandData";		
		Brand  brand=null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
			Query query=(Query)session.createQuery("from Brand where brandId=:id")
					.setParameter("id",brandIds);
			brand =(Brand)query.uniqueResult();						
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());	
		}		
		return brand;
	}
	
	public Category fetchCategoryID(Integer categoryId) {
		long brandIds=categoryId.longValue();		
		final String METHOD_NAME = "fetchCategoryID";
		Category category=null;
		try{			
			Session session = this.sessionFactory.getCurrentSession();
			Query query=(Query)session.createQuery("from Category where categoryId=:id")
					.setParameter("id",brandIds);
			category =(Category)query.uniqueResult();
			
		}catch(Exception exception)
		{
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
			
		}
		
		return category;
	}
	public boolean insertPromotions(List<PromotionSummary> list) {	
		
		final String METHOD_NAME = "insertPromotions";		
		boolean flag=false;
		try{
			Session session = this.sessionFactory.getCurrentSession();
			for(PromotionSummary promotionSummary2:list){				
			session.save(promotionSummary2);
			}
						
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
			flag=true;			
		}	
		return flag;		
	}

}
