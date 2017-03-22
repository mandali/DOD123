package com.omniwyse.dod.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.DTO.CategoryPromotion;
import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.DTO.PromotionDto;
import com.omniwyse.dod.dao.MerchantDao;
import com.omniwyse.dod.dao.PromotionsDao;
import com.omniwyse.dod.model.Brand;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.IdBasePromotion;
import com.omniwyse.dod.model.Location;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.Product;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.PromotionSummary;

@Repository
public class PromotionsDaoImpl implements PromotionsDao{
	
	private static final Logger logger = Logger.getLogger(PromotionsDaoImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
    MerchantDao merchantDao;

	@SuppressWarnings("unchecked")
	public List<Promotion> getPromotions() {
		final String METHOD_NAME="getPromotions";
		List<Promotion> list = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();		
		list = session.createQuery(" from Promotion ").list();
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return list;	
	}
	
	@SuppressWarnings("unchecked")
	public List<Promotion> getCategoryPromotions(Date currentdate, CategorySelection categorySelection) {
		final String METHOD_NAME="getCategoryPromotions";
		List<Promotion> list = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();	
		list = session.createQuery(" from Promotion p where :currentDate between p.startdate and p.enddate and p.category_name =:name")
				.setParameter("name", categorySelection.getCategoryname().trim())
				.setParameter("currentDate", currentdate).list();	
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return list;
	}

	public Promotion createPromotions(CreatePromotionVo createPromotionVo) {
		final String METHOD_NAME="createPromotions";
		Promotion resp = null;
		try{
		Promotion promotion=new Promotion();
		Session session = this.sessionFactory.getCurrentSession();
		Brand brand= (Brand) session.get(Brand.class, Long.valueOf(createPromotionVo.getBrandId()));
		promotion.setBrandId(brand);
		Category category=(Category) session.get(Category.class, Long.valueOf(createPromotionVo.getCatid()));
		promotion.setCatid(category);
		promotion.setProductID(createPromotionVo.getProductId());
		promotion.setDescription(createPromotionVo.getDescription());
		promotion.setMerchatId(createPromotionVo.getMerchantProfile());
		promotion.setOriginalPrice(createPromotionVo.getOriginalPrice());
		promotion.setDiscount(createPromotionVo.getDiscount());
		Location location=merchantDao.fetchLocationById(Long.valueOf(createPromotionVo.getLocationId()));
		if(location!=null){
		promotion.setLocationId(location);
		}
		promotion.setCreateddate(createPromotionVo.getCreateddate());
		promotion.setStartdate(createPromotionVo.getStartdate());
		promotion.setEnddate(createPromotionVo.getEnddate());
		promotion.setDiscountText(createPromotionVo.getDiscountText());
		Integer id = (Integer) session.save(promotion);
		resp=(Promotion) session.get(Promotion.class, id);
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());	
		}
		return resp;
		}

	public Promotion getIdbasePromotion(IdBasePromotion idBasePromotion) {
		final String METHOD_NAME="getIdbasePromotion";
		Promotion resp = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();	
		Query query=(Query)session.createQuery(" from Promotion where id=:id").setParameter("id",idBasePromotion.getPromotion_id());
		resp=(Promotion)((org.hibernate.Query) query).uniqueResult();
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());	
		}
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<PromotionSummary> promotionSummary(Date date) {
		final String METHOD_NAME="getIdbasePromotion";
		List<PromotionSummary> list = null ;
		try{
		Session session = this.sessionFactory.getCurrentSession();			
		list = session.createQuery(" from Promotionsummary ").list();
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());	
		}
		return list;
	}

	public Category getcategoryId(CreatePromotionVo createPromotionVo) {
		final String METHOD_NAME="getcategoryId";
		Category category = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query)session.createQuery(" from Category where categoryId=:categoryId ")
				.setParameter("categoryId",Long.valueOf(createPromotionVo.getCatid()));
		category =(Category)query.uniqueResult();
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return category;
	}
	public Brand getBrandId(CreatePromotionVo createPromotionVo) {
		final String METHOD_NAME="getBrandId";
		Brand brand = null ;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query)session.createQuery(" from Brand where brandId=:brandId ")
				.setParameter("brandId",Long.valueOf(createPromotionVo.getBrandId()));
		brand =(Brand)query.uniqueResult();
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return brand;
	}	
	@SuppressWarnings({"unchecked" })
	public List<PromotionDto> categoryIdPromotion(CategoryPromotion categoryPromotion) {	
		final String METHOD_NAME="CategoryIdPromotion";
		List<PromotionDto>  promotionDtos=new ArrayList<PromotionDto>();
		try{
		Session session = this.sessionFactory.getCurrentSession();	
		List<Promotion> promotions =session.createQuery("select distinct p from Promotion p where p.catid.categoryId=:id")
				.setParameter("id" ,categoryPromotion.getCategoryId()).list();	
		for(Promotion promotion:promotions){
			PromotionDto promotionDto=new PromotionDto();
			promotionDto.setId(promotion.getId());
			promotionDto.setProduct_id(String.valueOf(promotion.getProductID().getProductId()));
			promotionDto.setProduct_image(promotion.getProductID().getProductImageLocation());
			promotionDto.setDescription(promotion.getDescription());
			promotionDto.setOriginalPrice(promotion.getOriginalPrice());
			promotionDto.setDiscount(promotion.getDiscount());
			promotionDto.setStartdate(promotion.getStartdate());
			promotionDto.setCreateddate(promotion.getCreateddate());
			promotionDto.setEnddate(promotion.getEnddate());
			promotionDto.setLocationId(String.valueOf(promotion.getLocationId().getLocationId()));
			promotionDto.setLocationName(promotion.getLocationId().getLocationName());
			promotionDto.setMerchatId(promotion.getMerchatId().getMerchantId());
			promotionDto.setBrandId(promotion.getBrandId().getBrandid());
			promotionDto.setBrandName(promotion.getBrandId().getBrandName());
			promotionDto.setBrandImage(promotion.getBrandId().getBrandImage());
			promotionDto.setBrandRating(promotion.getBrandId().getBrandRating());
			promotionDto.setBrandDescription(promotion.getBrandId().getBrandDescription());
			promotionDto.setCategoryName(promotion.getCatid().getCategoryName());
			promotionDto.setCatid(promotion.getCatid().getCategoryId());
			promotionDto.setDiscountText(promotion.getDiscountText());
			promotionDtos.add(promotionDto);	
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return promotionDtos;			
	}
	
	
	
	@SuppressWarnings({ "unchecked"})
	public List<PromotionDto> brandIdPromotion(CategoryPromotion categoryPromotion) {
		final String METHOD_NAME="brandIdPromotion";
		List<PromotionDto>  promotionDtos=new ArrayList<PromotionDto>();
		try{
		Session session = this.sessionFactory.getCurrentSession();			
		List<Promotion> promotions = session.createQuery("select distinct p from Promotion p where p.brandId.brandId=:id").setParameter("id" , categoryPromotion.getBrandId()).list();		
		for(Promotion promotion:promotions){
			PromotionDto promotionDto=new PromotionDto();
			promotionDto.setId(promotion.getId());
			promotionDto.setProduct_id(String.valueOf(promotion.getProductID().getProductId()));
			promotionDto.setProduct_image(promotion.getProductID().getProductImageLocation());
			promotionDto.setDescription(promotion.getDescription());
			promotionDto.setOriginalPrice(promotion.getOriginalPrice());
			promotionDto.setDiscount(promotion.getDiscount());
			promotionDto.setStartdate(promotion.getStartdate());
			promotionDto.setCreateddate(promotion.getCreateddate());
			promotionDto.setEnddate(promotion.getEnddate());
			promotionDto.setLocationId(String.valueOf(promotion.getLocationId().getLocationId()));
			promotionDto.setLocationName(promotion.getLocationId().getLocationName());
			promotionDto.setMerchatId(promotion.getMerchatId().getMerchantId());
			promotionDto.setBrandId(promotion.getBrandId().getBrandid());			
			promotionDto.setBrandName(promotion.getBrandId().getBrandName());
			promotionDto.setBrandImage(promotion.getBrandId().getBrandImage());
			promotionDto.setBrandRating(promotion.getBrandId().getBrandRating());
			promotionDto.setBrandDescription(promotion.getBrandId().getBrandDescription());
			promotionDto.setCategoryName(promotion.getCatid().getCategoryName());
			promotionDto.setCatid(promotion.getCatid().getCategoryId());
			promotionDto.setDiscountText(promotion.getDiscountText());
			promotionDtos.add(promotionDto);	
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return promotionDtos;	
	}
		
	@SuppressWarnings("unchecked")
	public List<PromotionDto> brandCatIdPromotion(CategoryPromotion categoryPromotion) {
		final String METHOD_NAME="brandIdPromotion";
		List<PromotionDto>  promotionDtos=new ArrayList<PromotionDto>();
		try{
		Session session = this.sessionFactory.getCurrentSession();			
		List<Promotion> promotions = session.createQuery("select distinct p from Promotion p where p.brandId.brandId=:brandId and p.catid.categoryId=:categoryId")
				.setParameter("brandId" , categoryPromotion.getBrandId()).setParameter("categoryId",categoryPromotion.getCategoryId()).list();		
		for(Promotion promotion:promotions){
			PromotionDto promotionDto=new PromotionDto();
			promotionDto.setId(promotion.getId());
			promotionDto.setProduct_id(String.valueOf(promotion.getProductID().getProductId()));
			promotionDto.setProduct_image(promotion.getProductID().getProductImageLocation());
			promotionDto.setDescription(promotion.getDescription());
			promotionDto.setOriginalPrice(promotion.getOriginalPrice());
			promotionDto.setDiscount(promotion.getDiscount());
			promotionDto.setStartdate(promotion.getStartdate());
			promotionDto.setCreateddate(promotion.getCreateddate());
			promotionDto.setEnddate(promotion.getEnddate());
			promotionDto.setLocationId(String.valueOf(promotion.getLocationId().getLocationId()));
			promotionDto.setLocationName(promotion.getLocationId().getLocationName());
			promotionDto.setMerchatId(promotion.getMerchatId().getMerchantId());
			promotionDto.setBrandName(promotion.getBrandId().getBrandName());
			promotionDto.setBrandImage(promotion.getBrandId().getBrandImage());
			promotionDto.setBrandRating(promotion.getBrandId().getBrandRating());
			promotionDto.setBrandDescription(promotion.getBrandId().getBrandDescription());
			promotionDto.setCategoryName(promotion.getCatid().getCategoryName());
			promotionDto.setCatid(promotion.getCatid().getCategoryId());
			promotionDto.setBrandId(promotion.getBrandId().getBrandid());
			promotionDto.setDiscountText(promotion.getDiscountText());
			promotionDtos.add(promotionDto);	
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return promotionDtos;
	}

	public Product fetchProductById(CreatePromotionVo createPromotionVo) {		
		final String METHOD_NAME="fetchProductById";
		Product product = null;
		try{
			Session session = this.sessionFactory.getCurrentSession();		
			Query query=(Query) session.createQuery("from Product where productId=:productId");
			query.setParameter("productId", Long.valueOf(createPromotionVo.getProduct_id()));		
			product=(Product) query.uniqueResult();
			
		}
		catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}		
		return product;
	}

	public boolean updatePromotions(CreatePromotionVo createPromotionVo) {
		final String METHOD_NAME="updatePromotions";
		boolean flag=true;
		Date date=new Date();
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Promotion resp = (Promotion) session.get(Promotion.class, createPromotionVo.getId());
			resp.setDescription(createPromotionVo.getDescription());
			resp.setOriginalPrice(createPromotionVo.getOriginalPrice());
			resp.setDiscount(createPromotionVo.getDiscount());			
			MerchantProfile merchantProfile=(MerchantProfile) session.get(MerchantProfile.class, Integer.valueOf(createPromotionVo.getMerchatid()));
			if(merchantProfile!=null){
			resp.setMerchatId(merchantProfile);
			}
			Product product=(Product) session.get(Product.class, Long.valueOf(((createPromotionVo.getpId()))));
			if(product!=null){
				resp.setProductID(product);
			}
			Category category=(Category) session.get(Category.class, Long.valueOf((createPromotionVo.getCatid())));
			if(category!=null){
				resp.setCatid(category);
			}
			Brand brand=(Brand) session.get(Brand.class, Long.valueOf((createPromotionVo.getBrandId())));
			if(brand!=null){
				resp.setBrandId(brand);
			}
			Location location=(Location) session.get(Location.class, Long.valueOf((createPromotionVo.getLocationId())));
			if(location!=null){
				resp.setLocationId(location);
			}
			resp.setDiscountText(createPromotionVo.getDiscountText());
			resp.setCreateddate(date);
			resp.setStartdate(date);
			resp.setEnddate(date);
			session.saveOrUpdate(resp);			
			
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
			flag=false;	
		}
		return flag;
	}

	public boolean deletePromotions(CreatePromotionVo createPromotionVo) {
		final String METHOD_NAME="deletePromotions";
		boolean flag=true;
		try{
			Session session = this.sessionFactory.getCurrentSession();			
			Promotion promotion =(Promotion) session.load(Promotion.class, createPromotionVo.getId());
			if (promotion != null) {
				session.delete(promotion);				
			}			
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
			flag=false;	
		}
		return flag;
	}
		

}
