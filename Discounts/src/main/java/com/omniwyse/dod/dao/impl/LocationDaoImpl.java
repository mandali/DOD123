package com.omniwyse.dod.dao.impl;

import java.util.List;

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

	@SuppressWarnings("unchecked")
	public List<Country> fetchCountriesList() {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Country");
		List<Country> countries=(List<Country>)query.list();
		return countries;
	}
	@SuppressWarnings("unchecked")
	public List<Cities> fetchCitiesList() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Cities");
		List<Cities> cities=(List<Cities>)query.list();
		return cities;
	}
	@SuppressWarnings("unchecked")
	public List<Location> fetchLocationsList() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Location");
		List<Location> locations=(List<Location>)query.list();
		return locations;
	}
}
