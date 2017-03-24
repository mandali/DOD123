package com.omniwyse.dod.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.dao.BrandDao;
import com.omniwyse.dod.model.Brand;
@Repository
public class BrandDaoImpl implements BrandDao{
	
	private static final Logger LOGGER = Logger.getLogger(BrandDaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;	
	public Brand fetchBrand(Long id) {
		
		final String METHOD_NAME = "fetchCategory";
		Brand brand=null;	
		try{			
			Session session = this.sessionFactory.getCurrentSession();
			Query query=(Query) session.createQuery("from Brand where brandId=:id").setParameter("id", id);
			brand=(Brand)query.uniqueResult();			
		}catch(Exception exception){
			LOGGER.error("Exception in " + METHOD_NAME + "" + exception.getMessage());		
		}		
		return brand;
	}

}
