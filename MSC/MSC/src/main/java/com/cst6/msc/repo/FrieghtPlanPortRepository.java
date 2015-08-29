/**
 * 
 */
package com.cst6.msc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.FrieghtPlanPort;

/**
 * @author SasankaN
 *
 */
@Repository
public interface FrieghtPlanPortRepository extends JpaRepository<FrieghtPlanPort, Integer> {

//	@Query("select fpp from FrieghtPlanPort fpp where fpp.name like %?1")
//	List<CommodityCategory> findByNameContaining(String searchData);
}
