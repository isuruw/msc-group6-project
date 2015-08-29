/**
 * 
 */
package com.cst6.msc.model;

import java.util.Objects;

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
@Table(name="customer_address")
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="customer_id", referencedColumnName="id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="address_id", referencedColumnName="id")
	private Address address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("CustomerAddress[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("customer=").append(getCustomer()).append(",");
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
		
		if(obj instanceof CustomerAddress){
			CustomerAddress other = (CustomerAddress) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}
}
