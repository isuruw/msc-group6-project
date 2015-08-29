/**
 * 
 */
package com.cst6.msc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.model.SystemUser;

/**
 * @author SasankaN
 *
 */
@Repository
public interface SystemUserRepository extends
		JpaRepository<SystemUser, Integer> {

	SystemUser findByUsername(String username);

	List<SystemUser> findByIsActive(Boolean booleanType);

	@Modifying
	@Transactional
	@Query("delete from SystemUser su where su.id = ?1")
	void deleteById(Integer id);

	@Query("select su from SystemUser su where su.name like %?1 or su.username like %?1")
	List<SystemUser> findByNameContaining(String searchData);
}
