/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.City;

/**
 * @author SasankaN
 *
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

	List<City> findAll();
	
	City findById(Integer cityId);
}
