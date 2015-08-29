/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.Country;

/**
 * @author SasankaN
 *
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

	List<Country> findAll();
	
	Country findById(Integer countryId);
}
