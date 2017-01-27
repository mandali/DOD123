package com.omni.dod.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omni.dod.dao.DODDao;
import com.omni.dod.model.ConsumerRegistration;
import com.omni.dod.model.Promotions;
import com.omni.dod.model.RegisterWithOtp;
import com.omni.dod.model.UserProfile;

@Repository
public class DODDaoImpl implements DODDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public ConsumerRegistration save(ConsumerRegistration consumerRegistration) {
		Session session = this.sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(consumerRegistration);
		ConsumerRegistration reg = (ConsumerRegistration) session.get(ConsumerRegistration.class, id);		return reg;
	}

	public List<ConsumerRegistration> getConsumers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ConsumerRegistration> list = session.createQuery("from ConsumerRegistration").list();
		return list;
	}

	public RegisterWithOtp savewithotp(RegisterWithOtp registerWithOtp) {		
		Session session = this.sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(registerWithOtp);
		RegisterWithOtp reg=(RegisterWithOtp) session.get(RegisterWithOtp.class, id);
		return reg;
	}

	public UserProfile registeruser(UserProfile userProfile) {		
		Session session = this.sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(userProfile);
		UserProfile resp=(UserProfile) session.get(UserProfile.class, id);		
		return resp;
	}

		public List<Promotions> getPromotions(Date currentdate) {		
		Session session = this.sessionFactory.getCurrentSession();		
		List<Promotions> list = session.createQuery("from Promotions p where :currentDate between p.startdate and p.enddate")
				.setParameter("currentDate", currentdate).list();
		System.out.println(list.size());
		return list;
	}

		
	
}
