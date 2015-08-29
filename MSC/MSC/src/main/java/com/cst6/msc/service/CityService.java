/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.model.City;

/**
 * @author SasankaN
 *
 */
public interface CityService {

	List<City> getAllCities();
	
	City getCityById(Integer cityId);
}
