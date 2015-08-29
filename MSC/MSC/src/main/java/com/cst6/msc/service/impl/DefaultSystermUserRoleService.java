/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cst6.msc.model.SystemUserRole;
import com.cst6.msc.repo.SystemUserRoleRepository;
import com.cst6.msc.service.SystemUserRoleService;

/**
 * @author SasankaN
 *
 */
@Component("systemUserRoleService")
public class DefaultSystermUserRoleService implements SystemUserRoleService {

	@Autowired
	private SystemUserRoleRepository systemUserRoleRepo;
	
	/**
	 * getSystemUserRoles
	 */
	@Override
	public List<SystemUserRole> getAllSystemUserRoles() {
		return systemUserRoleRepo.findAll();
	}

	/**
	 * getSystemUserRoleByRoleName
	 */
	@Override
	public SystemUserRole getSystemUserRoleByRoleName(String roleName) {
		return systemUserRoleRepo.findByRoleName(roleName);
	}

	/**
	 * getSystemUserRoleById
	 */
	@Override
	public SystemUserRole getSystemUserRoleById(Integer id) {
		return systemUserRoleRepo.findById(id);
	}

}
