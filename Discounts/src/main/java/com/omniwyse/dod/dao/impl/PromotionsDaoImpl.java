package com.omniwyse.dod.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.dao.PromotionsDao;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.IdBasePromotion;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.RegisterWithOtp;

@Repository
public class PromotionsDaoImpl implements PromotionsDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Promotion> getPromotions(Date currentdate) {
		Session session = this.sessionFactory.openSession();			
		List<Promotion> list = session.createQuery(" from Promotion p where :currentDate between p.startdate and p.enddate")
				.setParameter("currentDate", currentdate).list();	
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

	public Promotion CreatePromotions(Promotion promotion) {
		Session session = this.sessionFactory.getCurrentSession();
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

}
