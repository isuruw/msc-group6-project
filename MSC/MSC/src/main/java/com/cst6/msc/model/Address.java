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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cst6.msc.dto.AddressDTO;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="street_no", nullable=false)
	private String streetNo;
	
	@Column(name="street_name1", nullable=false)
	private String streetName1;
	
	@Column(name="street_name2")
	private String streetName2;
	
	@ManyToOne
	@JoinColumn(name="city_id", referencedColumnName="id")
	private City city;
	
	public Address(){
		
	}
	
	public Address(AddressDTO addressDTO){
		this.id = addressDTO.getId();
		this.streetNo = addressDTO.getStreetNo();
		this.streetName1 = addressDTO.getStreetName1();
		this.streetName2 = addressDTO.getStreetName2();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getStreetName1() {
		return streetName1;
	}

	public void setStreetName1(String streetName1) {
		this.streetName1 = streetName1;
	}

	public String getStreetName2() {
		return streetName2;
	}

	public void setStreetName2(String streetName2) {
		this.streetName2 = streetName2;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("Address[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("streetNo=").append(getStreetNo()).append(",");
		newSB.append("streetName1=").append(getStreetName1()).append(",");
		newSB.append("streetName2=").append(getStreetName2()).append(",");
		newSB.append("city=").append(getCity());
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
		
		if(obj instanceof City){
			City other = (City) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}
}
