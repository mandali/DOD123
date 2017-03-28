package com.omniwyse.dod.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.dao.LocationDao;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.Cities;
import com.omniwyse.dod.model.Country;
import com.omniwyse.dod.model.Location;

@Repository
public class LocationDaoImpl implements LocationDao{
	
	@Autowired
	SessionFactory sessionFactory;	
	
	private static final Logger LOGGER = Logger.getLogger(LocationDaoImpl.class);
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
			LOGGER.error("Exception in " + METHOD_NAME + "" + exception.getMessage());			

		}
		return countries;
	}
	@SuppressWarnings("unchecked")
	public List<Cities> fetchCitiesList(Long countryId) {
		final String METHOD_NAME = "fetchCitiesList";
		List<Cities> cities = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Cities where countryId.countryId=:id").setParameter("id", countryId);
		cities=(List<Cities>)query.list();
		}catch(Exception exception)
		{
			LOGGER.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return cities;
	}
	@SuppressWarnings("unchecked")
	public List<Location> fetchLocationsList(Long countryId, Long cityId) {
		final String METHOD_NAME = "fetchCitiesList";
		List<Location> locations = null;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Location where countryId.countryId=:countryid and citiesId.cityId=:cityid")
				.setParameter("countryid", countryId).setParameter("cityid", cityId);
		locations=(List<Location>)query.list();
		}catch(Exception  exception)
		{
			LOGGER.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return locations;
	}
	public Location fetchLocation(Long id) {
		final String METHOD_NAME = "fetchLocation";
		Location location=null;		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query query=(Query) session.createQuery("from Location where locationId=:id").setParameter("id", id);
			location=(Location)query.uniqueResult();			
		}catch(Exception exception){
			LOGGER.error("Exception in " + METHOD_NAME + "" + exception.getMessage());			
		}		
		return location;
	}
}
