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

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="city")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="code", nullable=false)
	private String code;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="is_active", nullable=false)
	private Boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="country_id", referencedColumnName="id")
	private Country country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("City[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("code=").append(getCode()).append(",");
		newSB.append("name=").append(getName()).append(",");
		newSB.append("description=").append(getDescription()).append(",");
		newSB.append("isActive=").append(getIsActive()).append(",");
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
		
		if(obj==this)
			return true;
		
		if(obj instanceof City){
			City other = (City) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}

}
