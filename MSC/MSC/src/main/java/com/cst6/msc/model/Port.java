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

import com.cst6.msc.dto.PortDTO;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="port")
public class Port {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="code", nullable=false)
	private String code;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="longitude")
	private Double longitude;

	@Column(name="latitude")
	private Double latitude;
	
	@Column(name="is_active", nullable=false)
	private Boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="city_id", referencedColumnName="id")
	private City city;
	
	public Port(){
		
	}
	
	public Port(PortDTO portDTO){
		this.id = portDTO.getId();
		this.code = portDTO.getCode();
		this.name = portDTO.getName();
		this.longitude = portDTO.getLongitude();
		this.latitude = portDTO.getLatitude();
		this.isActive = portDTO.getIsActive();
	}

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
	
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("Port[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("code=").append(getCode()).append(",");
		newSB.append("name=").append(getName()).append(",");
		newSB.append("longitude=").append(getName()).append(",");
		newSB.append("latitude=").append(getName()).append(",");
		newSB.append("isActive=").append(getIsActive()).append(",");
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
		
		if(obj instanceof Port){
			Port other = (Port) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}
}
