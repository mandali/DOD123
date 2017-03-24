package com.omniwyse.dod.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.dao.CategoryDao;
import com.omniwyse.dod.model.Category;
@Repository
public class CategoryDaoImpl implements CategoryDao{
	
	private static final Logger logger = Logger.getLogger(ConsumerDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;	
	public Category fetchCategory(Long id) {
		
		final String METHOD_NAME = "fetchCategory";
		Category category=null;		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query query=(Query) session.createQuery("from Category where categoryId=:id").setParameter("id", id);
			category=(Category)query.uniqueResult();			
		}catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());			
		}		
		return category;		
	}
}
