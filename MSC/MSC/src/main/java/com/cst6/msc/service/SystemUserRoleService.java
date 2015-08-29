/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.model.SystemUserRole;

/**
 * @author SasankaN
 *
 */
public interface SystemUserRoleService {

	SystemUserRole getSystemUserRoleByRoleName(String roleName);
	
	SystemUserRole getSystemUserRoleById(Integer roleId);
	
	List<SystemUserRole> getAllSystemUserRoles();
}
