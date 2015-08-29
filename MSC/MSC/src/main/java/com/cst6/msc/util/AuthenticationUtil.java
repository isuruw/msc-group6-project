/**
 * 
 */
package com.cst6.msc.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author user
 *
 */
public class AuthenticationUtil {

	public static UserDetailsAdaptor getUserDetailsAdaptor(){
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		UserDetailsAdaptor userDetailsAdaptor = (UserDetailsAdaptor) auth.getPrincipal();
		
		return userDetailsAdaptor;
	}
}
