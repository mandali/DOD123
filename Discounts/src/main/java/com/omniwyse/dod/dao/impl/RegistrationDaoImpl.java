package com.omniwyse.dod.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.dao.RegistrationDao;
import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.model.UserProfile;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {
	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(RegistrationDaoImpl.class);

		public RegisterWithOtp register(RegisterWithOtp registerWithOtp) {
			final String METHOD_NAME="Register";
			RegisterWithOtp reg = null;
			try{
				
			Session session = this.sessionFactory.getCurrentSession();
			Integer id = (Integer) session.save(registerWithOtp);
			reg=(RegisterWithOtp) session.get(RegisterWithOtp.class, id);
			}catch(Exception exception){
				logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
			}
			return reg;
		}
			
		public UserProfile registeruser(UserProfile userProfile) {
			final String METHOD_NAME="registeruser";
			UserProfile resp = null;
			try{
			Session session = this.sessionFactory.getCurrentSession();
			Integer id = (Integer) session.save(userProfile);
			resp=(UserProfile) session.get(UserProfile.class, id);	
			}catch(Exception exception)
			{
				logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());

			}
			return resp;
		}
			
}
