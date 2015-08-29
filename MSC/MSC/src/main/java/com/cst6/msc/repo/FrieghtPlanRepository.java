/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.FrieghtPlan;

/**
 * @author SasankaN
 *
 */
@Repository
public interface FrieghtPlanRepository extends JpaRepository<FrieghtPlan, Integer>{
	
	List<FrieghtPlan> findByShipId(Integer id);
	
	@Query("select fp from FrieghtPlan fp where fp.name like %?1")
	List<FrieghtPlan> findByNameContaining(String searchData);
}
