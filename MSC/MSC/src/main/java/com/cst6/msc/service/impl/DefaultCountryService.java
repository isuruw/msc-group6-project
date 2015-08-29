/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.model.Country;
import com.cst6.msc.repo.CountryRepository;
import com.cst6.msc.service.CountryService;

/**
 * @author SasankaN
 *
 */
@Component("countryService")
@Transactional(readOnly = true)
public class DefaultCountryService implements CountryService {
	
	@Autowired
	private CountryRepository countryRepository;

	/**
	 * getAllCountries 
	 */
	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public Country getCountryById(Integer countryId) {
		return countryRepository.findById(countryId);
	}

}
