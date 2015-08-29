/**
 * 
 */
package com.cst6.msc.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cst6.msc.dto.SystemUserDTO;

/**
 * @author SasankaN
 * @since 15th August 2015
 * 
 */
@Entity
@Table(name = "system_user")
public class SystemUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "image")
	private String image;

	@Column(name = "current_ip_address")
	private String currentIpAaddress;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "joined_date")
	private Date joinedDate;
	
	@Column(name = "is_active", nullable = false)
	private Boolean isActive;

	@ManyToOne
	@JoinColumn(name = "system_user_role_id", referencedColumnName = "id")
	private SystemUserRole systemUserRole;

	@ManyToOne
	@JoinColumn(name = "country_id", referencedColumnName = "id")
	private Country country;

	public SystemUser() {

	}

	public SystemUser(SystemUserDTO systemUserDTO) {
		this.name = systemUserDTO.getName();
		this.username = systemUserDTO.getUsername();
		this.password = systemUserDTO.getPassword();
		this.image = systemUserDTO.getImage();
		this.email = systemUserDTO.getEmail();
		this.joinedDate = systemUserDTO.getJoinedDate();
		this.isActive = systemUserDTO.getIsActive();
		//this.systemUserRole = systemUserDTO.getSystemUserRoleId();
	}

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCurrentIpAddress() {
		return currentIpAaddress;
	}

	public void setCurrentIpAddress(String currentIpAaddress) {
		this.currentIpAaddress = currentIpAaddress;
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

	public SystemUserRole getSystemUserRole() {
		return systemUserRole;
	}

	public void setSystemUserRole(SystemUserRole systemUserRole) {
		this.systemUserRole = systemUserRole;
	}

	public String getCurrentIpAaddress() {
		return currentIpAaddress;
	}

	public void setCurrentIpAaddress(String currentIpAaddress) {
		this.currentIpAaddress = currentIpAaddress;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("SystemUser[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("name=").append(getName()).append(",");
		newSB.append("username=").append(getUsername()).append(",");
		newSB.append("password=").append(getPassword()).append(",");
		newSB.append("image=").append(getImage()).append(",");
		newSB.append("currentIpAaddress=").append(getCurrentIpAddress())
				.append(",");
		newSB.append("email=").append(getEmail()).append(",");
		newSB.append("email=").append(getEmail()).append(",");
		newSB.append("joinedDate=").append(getJoinedDate()).append(",");
		newSB.append("systemUserRole=").append(getSystemUserRole());
		newSB.append("country=").append(getCountry());
		newSB.append("]");

		return newSB.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (obj == this)
			return true;

		if (obj instanceof SystemUser) {
			SystemUser other = (SystemUser) obj;
			return other.getId().equals(getId());
		}

		return false;
	}

}
