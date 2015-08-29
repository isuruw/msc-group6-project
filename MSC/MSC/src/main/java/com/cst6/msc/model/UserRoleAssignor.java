/**
 * 
 */
package com.cst6.msc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="user_role_assignor")
public class UserRoleAssignor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="assignor_role_id", referencedColumnName="id")
	private SystemUserRole assignorRole;
	
	@ManyToOne
	@JoinColumn(name="assignee_role_id", referencedColumnName="id")
	private SystemUserRole assigneeRole;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SystemUserRole getAssignorRole() {
		return assignorRole;
	}

	public void setAssignorRole(SystemUserRole assignorRole) {
		this.assignorRole = assignorRole;
	}

	public SystemUserRole getAssigneeRole() {
		return assigneeRole;
	}

	public void setAssigneeRole(SystemUserRole assigneeRole) {
		this.assigneeRole = assigneeRole;
	}

	

	

}
