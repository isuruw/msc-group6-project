/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.model.SystemUserRole;
import com.cst6.msc.model.UserRoleAssignor;
import com.cst6.msc.repo.UserRoleAssignorRepository;
import com.cst6.msc.service.UserRoleAssignorService;

/**
 * @author SasankaN
 *
 */
@Component("userRoleAssignorService")
@Transactional(readOnly = true)
public class DefaultUserRoleAssignorService implements UserRoleAssignorService{

	@Autowired
	private UserRoleAssignorRepository userRoleAssignorRepository;
	
	@Override
	public List<SystemUserRole> getAssigneesByAssignerId(Integer id) {
		List<UserRoleAssignor> userRoleAssignors = userRoleAssignorRepository.findByAssignorRoleId(id);
		List<SystemUserRole> systemUseRoles=new ArrayList<SystemUserRole>();
		for(UserRoleAssignor userRoleAssignor:userRoleAssignors) {
			systemUseRoles.add(userRoleAssignor.getAssigneeRole());
		}
		return systemUseRoles;
	}

}
