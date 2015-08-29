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
@Table(name="ship_category")
public class ShipCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="code", nullable=false)
	private String code;
	
	@Column(name="type", nullable=false)
	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("ShipCategory[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("code=").append(getCode()).append(",");
		newSB.append("type=").append(getType());
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
		
		if(obj instanceof ShipCategory){
			ShipCategory other = (ShipCategory) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}

}
