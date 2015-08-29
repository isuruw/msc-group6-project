/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.Port;

/**
 * @author user
 *
 */
@Repository
public interface PortRepository extends JpaRepository<Port, Integer>{

	List<Port> findByIsActive(Boolean booleanType);
	
	@Query("select p from Port p where p.name like %?1")
	List<Port> findByNameContaining(String searchData);
}
