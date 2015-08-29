/**
 * 
 */
package com.cst6.msc.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="system_user_role")
public class SystemUserRole {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="role_name", nullable=false)
	private String roleName;
	
	@Column(name="display_role_name")
	private String displayRoleName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDisplayRoleName() {
		return displayRoleName;
	}
	public void setDisplayRoleName(String displayRoleName) {
		this.displayRoleName = displayRoleName;
	}
	
	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("SystemUserRole[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("roleName=").append(getRoleName()).append(",");
		newSB.append("displayRoleName=").append(getDisplayRoleName());
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
		
		if(obj==this)
			return true;
		
		if(obj instanceof SystemUserRole){
			SystemUserRole other = (SystemUserRole) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}
	
}
