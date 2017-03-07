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
import com.omniwyse.dod.model.Product;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.Promotionsummary;

@Repository
public class PromotionsDaoImpl implements PromotionsDao{
	
	private static final Logger logger = Logger.getLogger(PromotionsDaoImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
    MerchantDao merchantDao;

	@SuppressWarnings("unchecked")
	public List<Promotion> getPromotions() {
		Session session = this.sessionFactory.openSession();		
		List<Promotion> list = session.createQuery(" from Promotion ").list();
		return list;	
	}
	
	@SuppressWarnings("unchecked")
	public List<Promotion> getCategoryPromotions(Date currentdate, CategorySelection categorySelection) {
		Session session = this.sessionFactory.getCurrentSession();	
		List<Promotion> list = session.createQuery(" from Promotion p where :currentDate between p.startdate and p.enddate and p.category_name =:name")
				.setParameter("name", categorySelection.getCategoryname().trim())
				.setParameter("currentDate", currentdate).list();			
		return list;
	}

	public Promotion createPromotions(CreatePromotionVo createPromotionVo) {				
		Promotion promotion=new Promotion();
		Session session = this.sessionFactory.getCurrentSession();
		Brand brand= (Brand) session.get(Brand.class, createPromotionVo.getBrandId());
		promotion.setBrandId(brand);
		Category category=(Category) session.get(Category.class, createPromotionVo.getCatid());
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
		Promotion resp=(Promotion) session.get(Promotion.class, id);		
		return resp;
		}

	public Promotion getIdbasePromotion(IdBasePromotion idBasePromotion) {
		Session session = this.sessionFactory.getCurrentSession();	
		Query query=(Query)session.createQuery(" from Promotion where id=:id").setParameter("id",idBasePromotion.getPromotion_id());
		Promotion resp=(Promotion)((org.hibernate.Query) query).uniqueResult();
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<Promotionsummary> PromotionSummary(Date date) {
		Session session = this.sessionFactory.openSession();			
		List<Promotionsummary> list = session.createQuery(" from Promotionsummary ").list();	
		return list;
	}

	public Category getcategoryId(CreatePromotionVo createPromotionVo) {
	
		Session session = this.sessionFactory.openSession();
		Query query=(Query)session.createQuery(" from Category where categoryId=:categoryId ")
				.setParameter("categoryId",createPromotionVo.getCatid());
		Category category =(Category)query.uniqueResult();	
		return category;
	}
	public Brand getBrandId(CreatePromotionVo createPromotionVo) {
		Session session = this.sessionFactory.openSession();
		Query query=(Query)session.createQuery(" from Brand where brandId=:brandId ")
				.setParameter("brandId",createPromotionVo.getBrandId());
		Brand brand =(Brand)query.uniqueResult();	
		return brand;
	}	
	@SuppressWarnings({"unchecked" })
	public List<PromotionDto> CategoryIdPromotion(CategoryPromotion categoryPromotion) {		
		List<PromotionDto>  promotionDtos=new ArrayList<PromotionDto>();
		Session session = this.sessionFactory.openSession();	
		List<Promotion> promotions =session.createQuery("select distinct p from Promotion p where p.catid.categoryId=:id")
				.setParameter("id" ,categoryPromotion.getCategoryId()).list();	
		for(Promotion promotion:promotions){
			PromotionDto promotionDto=new PromotionDto();
			promotionDto.setId(promotion.getId());
			promotionDto.setProduct_id(String.valueOf(promotion.getProductID().getProductId()));
			promotionDto.setDescription(promotion.getDescription());
			promotionDto.setOriginalPrice(promotion.getOriginalPrice());
			promotionDto.setDiscount(promotion.getDiscount());
			promotionDto.setStartdate(promotion.getStartdate());
			promotionDto.setCreateddate(promotion.getCreateddate());
			promotionDto.setEnddate(promotion.getEnddate());
			promotionDto.setLocationId(String.valueOf(promotion.getLocationId().getLocationId()));
			promotionDto.setLocationName(promotion.getLocationId().getLocationName());
			promotionDto.setMerchatId(promotion.getMerchatId().getId());
			promotionDto.setBrandName(promotion.getBrandId().getBrandName());
			promotionDto.setBrandImage(promotion.getBrandId().getBrandImage());
			promotionDto.setBrandRating(promotion.getBrandId().getBrandRating());
			promotionDto.setBrandDescription(promotion.getBrandId().getBrandDescription());
			promotionDto.setCategoryName(promotion.getCatid().getCategoryName());
			promotionDto.setCatid(promotion.getCatid().getCategoryId());
			promotionDtos.add(promotionDto);	
		}		
		return promotionDtos;			
	}
	
	
	
	@SuppressWarnings({ "unchecked"})
	public List<PromotionDto> brandIdPromotion(CategoryPromotion categoryPromotion) {	
		List<PromotionDto>  promotionDtos=new ArrayList<PromotionDto>();
		Session session = this.sessionFactory.openSession();			
		List<Promotion> promotions = session.createQuery("select distinct p from Promotion p where p.brandId.brandId=:id").setParameter("id" , categoryPromotion.getBrandId()).list();		
		for(Promotion promotion:promotions){
			PromotionDto promotionDto=new PromotionDto();
			promotionDto.setId(promotion.getId());
			promotionDto.setProduct_id(String.valueOf(promotion.getProductID().getProductId()));
			promotionDto.setDescription(promotion.getDescription());
			promotionDto.setOriginalPrice(promotion.getOriginalPrice());
			promotionDto.setDiscount(promotion.getDiscount());
			promotionDto.setStartdate(promotion.getStartdate());
			promotionDto.setCreateddate(promotion.getCreateddate());
			promotionDto.setEnddate(promotion.getEnddate());
			promotionDto.setLocationId(String.valueOf(promotion.getLocationId().getLocationId()));
			promotionDto.setLocationName(promotion.getLocationId().getLocationName());
			promotionDto.setMerchatId(promotion.getMerchatId().getId());
			promotionDto.setBrandName(promotion.getBrandId().getBrandName());
			promotionDto.setBrandImage(promotion.getBrandId().getBrandImage());
			promotionDto.setBrandRating(promotion.getBrandId().getBrandRating());
			promotionDto.setBrandDescription(promotion.getBrandId().getBrandDescription());
			promotionDto.setCategoryName(promotion.getCatid().getCategoryName());
			promotionDto.setCatid(promotion.getCatid().getCategoryId());
			promotionDtos.add(promotionDto);	
		}		
		return promotionDtos;	
	}
		
	@SuppressWarnings("unchecked")
	public List<PromotionDto> brandCatIdPromotion(CategoryPromotion categoryPromotion) {
		
		List<PromotionDto>  promotionDtos=new ArrayList<PromotionDto>();
		Session session = this.sessionFactory.openSession();			
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
			promotionDto.setMerchatId(promotion.getMerchatId().getId());
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
		return promotionDtos;
	}

	public Product fetchProductById(CreatePromotionVo createPromotionVo) {
		// TODO Auto-generated method stub
		final String METHOD_NAME="fetchProductById";
		Product product = null;
		try{
			Session session = this.sessionFactory.openSession();		
			Query query=(Query) session.createQuery("from Product where productId=:productId");
			query.setParameter("productId", Long.valueOf(createPromotionVo.getProduct_id()));		
			product=(Product) query.uniqueResult();
			
		}
		catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		
		
		return product;
	}
		

}
