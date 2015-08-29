/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.Customer;

/**
 * @author SasankaN
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByIsActive(Boolean booleanType);

	@Query("select c from Customer c where c.businessName like %?1")
	List<Customer> findByBusinessNameContaining(String searchData);

}
