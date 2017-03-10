package com.omniwyse.dod.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.dao.MerchantDao;
import com.omniwyse.dod.model.GetMerchantById;
import com.omniwyse.dod.model.GetMerchatProfile;
import com.omniwyse.dod.model.Location;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.MerchantPromotions;
import com.omniwyse.dod.model.Promotion;

@Repository
public class MerchantDaoImpl implements MerchantDao{
	
	@Autowired
	SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(MerchantDaoImpl.class);
	public MerchantProfile registermerchant(MerchantProfile merchantProfile) {
		final String METHOD_NAME = "registermerchant";
		MerchantProfile resp = null;
	try{
			Session session = this.sessionFactory.getCurrentSession();
			Integer id = (Integer) session.save(merchantProfile);
			resp=(MerchantProfile) session.get(MerchantProfile.class, id);
		}catch(Exception exception)
		{
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());		
		}
			return resp;	
		}
		
	public MerchantProfile getMerchatByMobile(GetMerchantById getMerchantById) {
		final String METHOD_NAME = "GetMerchatByMobile";
		MerchantProfile resp = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where  mobilenumber=:mobileno")
				.setParameter("mobileno",getMerchantById.getMobilenumber() );	
		 resp=(MerchantProfile) query.uniqueResult();
		}catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());	
		}
		return resp;
	}
			
	public MerchantProfile getMerchantbyID(Integer getMerchantById) {
		final String METHOD_NAME = "getMerchantbyID";
		MerchantProfile resp = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where  id=:id")
				.setParameter("id",getMerchantById );	
		resp=(MerchantProfile) query.uniqueResult();
		}catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());	
		}
		return resp;
	}
		
	public MerchantProfile getMerchant(MerchantLogin MerchantLogin) {
		final String METHOD_NAME = "GetMerchant";
		MerchantProfile MerchantProfile = null;
		try{
		Session session = this.sessionFactory.openSession();
		Query query=(Query) session.createQuery("from MerchantProfile where mobilenumber=:mobile").setParameter("mobile", MerchantLogin.getMobileno());
		MerchantProfile=(MerchantProfile)query.uniqueResult();
		}catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());	
		}
		return MerchantProfile;
	}
		
	public MerchantProfile merchantLogin(com.omniwyse.dod.model.MerchantLogin merchantLogin) {
		final String METHOD_NAME = "MerchantLogin";
		MerchantProfile resp = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where mobilenumber=:mobileno and password=:password");
		query.setParameter("mobileno", merchantLogin.getMobileno().trim())
		.setParameter("password", merchantLogin.getPassword().trim());		
		resp=(MerchantProfile)query.uniqueResult();
		}catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());	
		}
		return resp;
	}
		
	public MerchantProfile merchantautheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail) {
		final String METHOD_NAME = "merchantautheticateWithEmail";
		MerchantProfile resp = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where  password=:password and emailid=:emalid");
		query.setParameter("password", merchantLoginwithEmail.getPassword());
		query.setParameter("emalid", merchantLoginwithEmail.getEmail());
		resp=(MerchantProfile) query.uniqueResult();
		}catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return resp;
	}		
	public MerchantProfile merchantautheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile) {
		final String METHOD_NAME = "merchantautheticateWithMobile";
		MerchantProfile resp = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where  password=:password and mobilenumber=:mobile");
		query.setParameter("password", merchantLoginwithMobile.getPassword().trim());
		query.setParameter("mobile", merchantLoginwithMobile.getMobileno().trim());
		resp=(MerchantProfile) query.uniqueResult();
		}catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return resp;
	}		
	public MerchantProfile merchantProfile(GetMerchatProfile getMerchatProfile) {
		final String METHOD_NAME = "MerchantProfile";
		MerchantProfile resp = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where  mobilenumber=:mobileno");
		query.setParameter("mobileno", getMerchatProfile.getMobileno());		
		resp=(MerchantProfile) query.uniqueResult();
		}catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return resp;
	}		
	@SuppressWarnings("unchecked")
	public List<MerchantProfile> allMerchants() {
		final String METHOD_NAME = "AllMerchants";
		List<MerchantProfile> list = null ;
		try{
		Session session = this.sessionFactory.openSession();			
		list = session.createQuery(" from MerchantProfile ").list();
		}catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return list;
	}		
	@SuppressWarnings("unchecked")
	public List<Promotion> merchantPromotions(MerchantPromotions MerchantPromotions, Date date) {
		final String METHOD_NAME = "MerchantPromotions";
		List<Promotion> list = null;
		try{
		Session session = this.sessionFactory.openSession();		
		list= session.createQuery(" from Promotion p where p.merchatId.id=:merchantId").setParameter("merchantId",MerchantPromotions.getId()).list();
		}catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return list;
	}		
	public MerchantProfile validatePromotion(CreatePromotionVo createPromotionVo) {
		final String METHOD_NAME = "validatePromotion";
		MerchantProfile resp = null;
		try{
		Session session = this.sessionFactory.openSession();		
		Query query=(Query) session.createQuery("from MerchantProfile where  id=:merchatid");
		query.setParameter("merchatid", createPromotionVo.getMerchatid());		
		 resp=(MerchantProfile) query.uniqueResult();
		}
		catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return resp;
	}
	
	public Location fetchLocationById(Long locationId) {
		final String METHOD_NAME = "fetchLocationById";
		Location resp = null;
		try{
		Session session = this.sessionFactory.openSession();		
		Query query=(Query) session.createQuery("from Location where locationId=:locationId");
		query.setParameter("locationId", locationId);		
		 resp=(Location) query.uniqueResult();
		}
		catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return resp;
	}
		
	}


