/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.ShippingCompany;

/**
 * @author SasankaN
 *
 */
@Repository
public interface ShippingCompanyRepository extends JpaRepository<ShippingCompany, Integer> {

	List<ShippingCompany>  findByIsActive(Boolean booleanType);
	
	@Query("select sc from ShippingCompany sc where sc.businessName like %?1")
	List<ShippingCompany> findByBusinessNameContaining(String searchData);
}
