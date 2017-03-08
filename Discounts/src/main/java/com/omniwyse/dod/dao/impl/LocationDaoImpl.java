package com.omniwyse.dod.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.dao.LocationDao;
import com.omniwyse.dod.model.Cities;
import com.omniwyse.dod.model.Country;
import com.omniwyse.dod.model.Location;

@Repository
public class LocationDaoImpl implements LocationDao{
	
	@Autowired
	SessionFactory sessionFactory;	
	
	private static final Logger logger = Logger.getLogger(LocationDaoImpl.class);
;

	@SuppressWarnings("unchecked")
	public List<Country> fetchCountriesList() {
		final String METHOD_NAME = "fetchCountriesList";
		List<Country> countries = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Country");
		countries=(List<Country>)query.list();
		}catch(Exception exception)
		{
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());			

		}
		return countries;
	}
	@SuppressWarnings("unchecked")
	public List<Cities> fetchCitiesList() {
		final String METHOD_NAME = "fetchCitiesList";
		List<Cities> cities = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Cities");
		cities=(List<Cities>)query.list();
		}catch(Exception exception)
		{
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return cities;
	}
	@SuppressWarnings("unchecked")
	public List<Location> fetchLocationsList() {
		final String METHOD_NAME = "fetchCitiesList";
		List<Location> locations = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Location");
		locations=(List<Location>)query.list();
		}catch(Exception  exception)
		{
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return locations;
	}
}
