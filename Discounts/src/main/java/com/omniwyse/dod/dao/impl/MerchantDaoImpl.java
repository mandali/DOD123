package com.omniwyse.dod.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.dao.MerchantDao;
import com.omniwyse.dod.model.GetMerchantById;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;

@Repository
public class MerchantDaoImpl implements MerchantDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public MerchantProfile registermerchant(MerchantProfile merchantProfile) {					
			Session session = this.sessionFactory.getCurrentSession();
			Integer id = (Integer) session.save(merchantProfile);
			MerchantProfile resp=(MerchantProfile) session.get(MerchantProfile.class, id);		
			return resp;	
		}
	public MerchantProfile GetMerchatByMobile(GetMerchantById getMerchantById) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where  mobilenumber=:mobileno")
				.setParameter("mobileno",getMerchantById.getMobilenumber() );	
		MerchantProfile resp=(MerchantProfile) query.uniqueResult();		
		return resp;
	}
	public MerchantProfile GetMerchant(MerchantLogin MerchantLogin) {
		Session session = this.sessionFactory.openSession();
		Query query=(Query) session.createQuery("from MerchantProfile where mobilenumber=:mobile").setParameter("mobile", MerchantLogin.getMobileno());
		MerchantProfile MerchantProfile=(MerchantProfile)query.uniqueResult();
		return MerchantProfile;
	}
	public MerchantProfile MerchantLogin(com.omniwyse.dod.model.MerchantLogin merchantLogin) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where mobilenumber=:mobileno and password=:password");
		query.setParameter("mobileno", merchantLogin.getMobileno().trim())
		.setParameter("password", merchantLogin.getPassword().trim());		
		MerchantProfile resp=(MerchantProfile) query.uniqueResult();
		return resp;
	}
	public MerchantProfile merchantautheticateWithEmail(MerchantLoginwithEmail merchantLoginwithEmail) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where  password=:password and emailid=:emalid");
		query.setParameter("password", merchantLoginwithEmail.getPassword());
		query.setParameter("emalid", merchantLoginwithEmail.getEmail());
		MerchantProfile resp=(MerchantProfile) query.uniqueResult();		
		return resp;
	}
	public MerchantProfile merchantautheticateWithMobile(MerchantLoginwithMobile merchantLoginwithMobile) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from MerchantProfile where  password=:password and mobilenumber=:mobile");
		query.setParameter("password", merchantLoginwithMobile.getPassword().trim());
		query.setParameter("mobile", merchantLoginwithMobile.getMobileno().trim());
		MerchantProfile resp=(MerchantProfile) query.uniqueResult();		
		return resp;
	}
	}


