package com.omniwyse.dod.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.DTO.NewProductVO;
import com.omniwyse.dod.dao.ProductDao;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	private static final Logger logger = Logger.getLogger(ProductDaoImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;

	public Product createProduct(NewProductVO newProductVO,MerchantProfile merchantProfile) {
		Session session;
		Product product = null;
		try{
		// TODO Auto-generated method stub
		session = this.sessionFactory.getCurrentSession();
		product=new Product();
		product.setMerchantId(merchantProfile);
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
		Session session = this.sessionFactory.getCurrentSession();		
		Query query=(Query) session.createQuery("from MerchantProfile where  id=:merchatid");
		query.setParameter("merchatid", Integer.valueOf(productVO.getMerchantId()));		
		 resp=(MerchantProfile) query.uniqueResult();
		}
		catch(Exception exception){
			logger.error("Exception in validate promotion method"+exception.getMessage());
		}
		return resp;
	}
		
	@SuppressWarnings("unchecked")
	public Product validateProductname(NewProductVO productVO) {
		List<Product> resp=null;
		Product product = null;
			Session session = this.sessionFactory.getCurrentSession();		
			 resp= session.createQuery("from Product where productDescription=:productDescription")
					.setParameter("productDescription", productVO.getProductDescription()).list();	
			if(!resp.isEmpty()){
				
				for(Product productLocal:resp){
					if(productLocal.getProductDescription().equalsIgnoreCase(productVO.getProductDescription())){
					product=productLocal;
					break;
					}
				}
			return product;
			}
			
			return product;			
	}
		
}
