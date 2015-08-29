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
public interface UserRoleAssignorService {

	List<SystemUserRole> getAssigneesByAssignerId(Integer id);
}
