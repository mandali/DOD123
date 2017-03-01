package com.omniwyse.dod.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.DTO.NewProductVO;
import com.omniwyse.dod.config.AppConfiguration;
import com.omniwyse.dod.dao.ProductDao;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	private static final Logger logger = Logger.getLogger(AppConfiguration.class);
	
	@Autowired
	SessionFactory sessionFactory;

	public Product createProduct(NewProductVO newProductVO) {
		Session session;
		Product product = null;
		try{
		// TODO Auto-generated method stub
		session = this.sessionFactory.getCurrentSession();
		product=new Product();
		product.setMerchantId(Integer.valueOf(newProductVO.getMerchantId()));
		product.setProductDescription(newProductVO.getProductDescription());
		product.setProductImageLocation(newProductVO.getProductImage());
		Long id = (Long) session.save(product);
		product=(Product) session.get(Product.class, id);
		}
		catch(Exception exception){
			logger.error("Exception in createProduct method"+exception.getMessage());
		}
		return product;
	}
	
	public MerchantProfile validateProduct(NewProductVO productVO) {
		MerchantProfile resp = null;
		try{
		Session session = this.sessionFactory.openSession();		
		Query query=(Query) session.createQuery("from MerchantProfile where  id=:merchatid");
		query.setParameter("merchatid", Integer.valueOf(productVO.getMerchantId()));		
		 resp=(MerchantProfile) query.uniqueResult();
		}
		catch(Exception exception){
			logger.error("Exception in validate promotion method"+exception.getMessage());
		}
		return resp;
	}

	
}
