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
@Table(name="payment_mode")
public class PaymentMode {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="is_active", nullable=false)
	private Boolean isActive;

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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("PaymentMode[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("name=").append(getName()).append(",");
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
		
		if(obj instanceof PaymentMode){
			PaymentMode other = (PaymentMode) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}
}
