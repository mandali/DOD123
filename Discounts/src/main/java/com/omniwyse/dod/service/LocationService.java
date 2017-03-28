package com.omniwyse.dod.service;

import java.util.List;

import com.omniwyse.dod.model.Cities;
import com.omniwyse.dod.model.Country;
import com.omniwyse.dod.model.Location;

public interface LocationService {

	public List<Country> fetchCountriesList();

	public List<Cities> fetchCitiesList(Long countryId);

	public List<Location> fetchLocationsList(Long countryId, Long cityId);
	
	public Location fetchLocation(Long id);

}
