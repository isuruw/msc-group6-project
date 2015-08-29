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

import com.cst6.msc.dto.CustomerDTO;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="business_name", nullable=false)
	private String businessName;
	
	@Column(name="business_reg_no", nullable=false)
	private String businessRegNo;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="telephone_no", nullable=false)
	private String telephoneNo;
	
	@Column(name="fax_no")
	private String faxNo;
	
	@Column(name="is_active", nullable=false)
	private Boolean isActive;
	
	public Customer(){
		
	}
	
	public Customer(CustomerDTO customerDTO){
		this.id = customerDTO.getId();
		this.businessName = customerDTO.getBusinessName();
		this.businessRegNo = customerDTO.getBusinessRegNo();
		this.email = customerDTO.getEmail();
		this.password = customerDTO.getPassword();
		this.telephoneNo = customerDTO.getTelephoneNo();
		this.faxNo = customerDTO.getFaxNo();
		this.isActive = customerDTO.getIsActive();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessRegNo() {
		return businessRegNo;
	}

	public void setBusinessRegNo(String businessRegNo) {
		this.businessRegNo = businessRegNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("Customer[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("businessName=").append(getBusinessName()).append(",");
		newSB.append("businessRegNo=").append(getBusinessRegNo()).append(",");
		newSB.append("email=").append(getEmail()).append(",");
		newSB.append("password=").append(getPassword()).append(",");
		newSB.append("telephoneNo=").append(getTelephoneNo()).append(",");
		newSB.append("faxNo=").append(getFaxNo()).append(",");
		newSB.append("isActive=").append(getIsActive());
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
		
		if(obj instanceof Customer){
			Customer other = (Customer) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}
	
}
