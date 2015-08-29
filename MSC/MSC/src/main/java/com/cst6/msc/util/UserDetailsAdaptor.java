/**
 * 
 */
package com.cst6.msc.util;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cst6.msc.model.SystemUser;

/**
 * @author SasankaN
 *
 */
public class UserDetailsAdaptor implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2172915333121721213L;
	
	private SystemUser systemUser;
	private Collection<SimpleGrantedAuthority> gas;

	public UserDetailsAdaptor(SystemUser systemUser) {
		super();
		this.systemUser = systemUser;
		this.gas = Arrays.asList(new SimpleGrantedAuthority(systemUser
				.getSystemUserRole().getRoleName()));
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return gas;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return systemUser.getPassword();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return systemUser.getUsername();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getName() {
		return systemUser.getName();
	}
	
	public String getImage() {
		return systemUser.getImage();
	}
	
	public String getSystemUserRoleDisplayName() {
		return systemUser.getSystemUserRole().getDisplayRoleName();
	}
	
	public Integer getSystemUserRoleId() {
		return systemUser.getSystemUserRole().getId();
	}

}
