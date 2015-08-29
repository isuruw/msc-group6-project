/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.dto.SystemUserDTO;
import com.cst6.msc.model.SystemUser;
import com.cst6.msc.model.SystemUserRole;
import com.cst6.msc.repo.SystemUserRepository;
import com.cst6.msc.service.CountryService;
import com.cst6.msc.service.SystemUserRoleService;
import com.cst6.msc.service.SystemUserService;
import com.cst6.msc.service.UserRoleAssignorService;
import com.cst6.msc.util.AuthenticationUtil;
import com.cst6.msc.util.UserDetailsAdaptor;

/**
 * @author SasankaN
 *
 */
@Component("systemUserService")
@Transactional(readOnly = true)
public class DefaultSystemUserService implements SystemUserService,
		UserDetailsService {

	@Autowired
	private SystemUserRoleService systemUserRoleService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private UserRoleAssignorService userRoleAssignorService;
	
	@Autowired
	private SystemUserRepository systemUserRepository;

	@Override
	public SystemUser getSystemUserByUsername(String username) {
		return systemUserRepository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		SystemUser user = getSystemUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		UserDetails springUser = new UserDetailsAdaptor(user);
		
		return springUser;
	}

	@Override
	public List<SystemUser> getAllSystemUsers() {
		return systemUserRepository.findAll(sortByIdAsc());
	}
	
	private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "name");
    }

	@Transactional
	public void saveSystemUser(SystemUserDTO systemUserDTO) {
		
		List<SystemUserRole> allowedRoles = userRoleAssignorService.getAssigneesByAssignerId(AuthenticationUtil.getUserDetailsAdaptor().getSystemUserRoleId());
		
		SystemUser su = new SystemUser(systemUserDTO);
		Boolean isValid = false;
		for (SystemUserRole systemUserRole : allowedRoles) {
			
			/*if(su.getSystemUserRole().getId().equals(systemUserRole.getId())){
				isValid = true;
				break;
			}*/
			if(systemUserDTO.getSystemUserRoleId().equals(systemUserRole.getId())){
				isValid = true;
				break;
			}
		}
		
		if(!isValid){
			throw new RuntimeException("No priviledge to assign this role");
		}
		
		su.setJoinedDate(new Date());
		su.setCountry(countryService.getCountryById(systemUserDTO.getCountryId()));
		su.setSystemUserRole(systemUserRoleService.getSystemUserRoleById(systemUserDTO.getSystemUserRoleId()));		
		
		systemUserRepository.saveAndFlush(su);
		
	}

	@Override
	public void deleteSystemUser(Integer id) {
		systemUserRepository.deleteById(id);
	}

	@Override
	public List<SystemUser> getAllSystemUsers(Boolean booleanType) {
		return systemUserRepository.findByIsActive(booleanType);
	}

	@Override
	public List<SystemUser> searchAllSystemUsers(String searchData) {
		return systemUserRepository.findByNameContaining(searchData);
	}

}
