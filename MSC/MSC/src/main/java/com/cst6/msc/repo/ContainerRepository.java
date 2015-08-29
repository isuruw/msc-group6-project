/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.Container;

/**
 * @author SasankaN
 *
 */
@Repository
public interface ContainerRepository extends JpaRepository<Container, Integer> {

	List<Container>  findByIsActive(Boolean booleanType);
	
	@Query("select c from Container c where c.name like %?1")
	List<Container> findByNameContaining(String searchData);
}
