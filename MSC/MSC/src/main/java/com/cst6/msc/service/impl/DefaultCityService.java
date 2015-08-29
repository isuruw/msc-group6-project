/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.model.City;
import com.cst6.msc.repo.CityRepository;
import com.cst6.msc.service.CityService;

/**
 * @author SasankaN
 *
 */
@Component("cityService")
@Transactional(readOnly = true)
public class DefaultCityService implements CityService {

	@Autowired
	private CityRepository cityRepository;
	
	/**
	 * 
	 */
	@Override
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

	/**
	 * 
	 */
	@Override
	public City getCityById(Integer cityId) {
		return cityRepository.findById(cityId);
	}

}
