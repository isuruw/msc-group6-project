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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cst6.msc.dto.ShippingCompanyDTO;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="shipping_company")
public class ShippingCompany {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="business_name", nullable=false)
	private String businessName;
	
	@Column(name="business_reg_no", nullable=false)
	private String businessRegNo;
	
	@Column(name="is_active", nullable=false)
	private Boolean isActive;
	
	@OneToOne
	@JoinColumn(name="address_id", referencedColumnName="id")
	private Address address;	
	
	public ShippingCompany(){
		
	}
	
	public ShippingCompany(ShippingCompanyDTO shippingCompanyDTO){
		this.id = shippingCompanyDTO.getId();
		this.businessName = shippingCompanyDTO.getBusinessName();
		this.businessRegNo = shippingCompanyDTO.getBusinessRegNo();
		this.isActive = shippingCompanyDTO.getIsActive();
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("ShippingCompany[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("businessName=").append(getBusinessName()).append(",");
		newSB.append("businessRegNo=").append(getBusinessRegNo()).append(",");
		newSB.append("isActive=").append(getIsActive()).append(",");
		newSB.append("address=").append(getAddress());
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
		
		if(obj instanceof ShippingCompany){
			ShippingCompany other = (ShippingCompany) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}

}
