/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.UserRoleAssignor;

/**
 * @author SasankaN
 *
 */
@Repository
public interface UserRoleAssignorRepository extends JpaRepository<UserRoleAssignor, Integer>{

	public List<UserRoleAssignor> findByAssignorRoleId(Integer id);
	

}
