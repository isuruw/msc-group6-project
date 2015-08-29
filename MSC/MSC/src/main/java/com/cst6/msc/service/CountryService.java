/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.model.Country;

/**
 * @author SasankaN
 *
 */
public interface CountryService {

	List<Country> getAllCountries();
	
	Country getCountryById(Integer countryId);
}
