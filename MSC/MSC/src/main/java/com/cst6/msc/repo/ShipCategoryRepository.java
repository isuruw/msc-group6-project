/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.ShipCategory;

/**
 * @author SasankaN
 *
 */
@Repository
public interface ShipCategoryRepository extends JpaRepository<ShipCategory, Integer>{
	
	@Query("select sc from ShipCategory sc where sc.type like %?1")
	List<ShipCategory> findByTypeContaining(String searchData);
}
