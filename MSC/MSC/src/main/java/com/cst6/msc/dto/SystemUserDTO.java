/**
 * 
 */
package com.cst6.msc.dto;

import java.util.Date;


/**
 * @author user
 *
 */
public class SystemUserDTO {

	private Integer id;
	
	private String name;
	
	private String username;
	
	private String password;
	
	private String rePassword;
	
	private String image;
	
	private String email;
	
	private Date joinedDate;
	
	private Boolean isActive;
	
	private Integer systemUserRoleId;
	
	private Integer countryId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getSystemUserRoleId() {
		return systemUserRoleId;
	}

	public void setSystemUserRoleId(Integer systemUserRoleId) {
		this.systemUserRoleId = systemUserRoleId;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	
}
