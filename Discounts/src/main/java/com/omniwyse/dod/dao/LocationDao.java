package com.omniwyse.dod.dao;

import java.util.List;

import com.omniwyse.dod.model.Cities;
import com.omniwyse.dod.model.Country;
import com.omniwyse.dod.model.Location;

public interface LocationDao {

	public List<Country> fetchCountriesList();
	public List<Cities> fetchCitiesList();
	public List<Location> fetchLocationsList();
	public Location fetchLocation(Long id);
	
	
	
}
