/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.CommodityCategory;

/**
 * @author SasankaN
 *
 */
@Repository
public interface CommodityCategoryRepository extends JpaRepository<CommodityCategory, Integer> {

	List<CommodityCategory> findByIsActive(Boolean booleanType);
	
	@Query("select cc from CommodityCategory cc where cc.name like %?1")
	List<CommodityCategory> findByNameContaining(String searchData);
}
