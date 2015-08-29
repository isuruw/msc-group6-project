/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.Address;

/**
 * @author SasankaN
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	@Query("select a from Address a where a.streetNo like %?1 or a.streetName1 like %?1 or a.streetName2 like %?1")
	List<Address> findByStreetNoContaining(String searchData);
	
	//@Query("select a from Address a where a.streetNo like %?1 and a.streetName1 like %?2 and a.streetName2 like %?3 and a.city.id like %?4")
	Address findByStreetNoAndStreetName1AndStreetName2AndCityId(String streetNo, String streetName1, String streetName2, Integer cityId);
}
