/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.SystemUserRole;

/**
 * @author SasankaN
 *
 */
@Repository
public interface SystemUserRoleRepository extends JpaRepository<SystemUserRole, Integer>{

	SystemUserRole findByRoleName(String roleName);
	
	SystemUserRole findById(Integer id);
	
	List<SystemUserRole> findAll();
}
