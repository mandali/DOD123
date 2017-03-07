package com.omniwyse.dod.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omniwyse.dod.dao.LocationDao;
import com.omniwyse.dod.model.Cities;
import com.omniwyse.dod.model.Country;
import com.omniwyse.dod.model.Location;
import com.omniwyse.dod.service.LocationService;


@Service
@Transactional
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	LocationDao locationDao;

	public List<Country> fetchCountriesList() {
		// TODO Auto-generated method stub
		return locationDao.fetchCountriesList();
	}
		
	public List<Cities> fetchCitiesList() {
		// TODO Auto-generated method stub
		return locationDao.fetchCitiesList();
	}
		
	public List<Location> fetchLocationsList() {
		// TODO Auto-generated method stub
		return locationDao.fetchLocationsList();
	}
		

}
