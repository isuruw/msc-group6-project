/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.Ship;

/**
 * @author SasankaN
 *
 */
@Repository
public interface ShipRepository extends JpaRepository<Ship, Integer> {

	List<Ship> findByIsActive(Boolean booleanType);

	@Query("select s from Ship s where s.name like %?1")
	List<Ship> findByNameContaining(String searchData);
}
