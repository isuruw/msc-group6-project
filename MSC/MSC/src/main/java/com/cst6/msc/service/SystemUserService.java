/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.dto.SystemUserDTO;
import com.cst6.msc.model.SystemUser;

/**
 * @author SasankaN
 *
 */
public interface SystemUserService {

	SystemUser getSystemUserByUsername(String username);
	
	List<SystemUser> getAllSystemUsers();
	
	List<SystemUser> getAllSystemUsers(Boolean booleanType);
	
	List<SystemUser> searchAllSystemUsers(String searchData);
	
	void saveSystemUser(SystemUserDTO systemUserDTO);
	
	void deleteSystemUser(Integer id);
}
