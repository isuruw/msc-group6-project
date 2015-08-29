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

import com.cst6.msc.dto.CommodityCategoryDTO;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="commodity_category")
public class CommodityCategory {

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

	public CommodityCategory(){
		
	}
	
	public CommodityCategory(CommodityCategoryDTO commodityCategoryDTO){
		this.id = commodityCategoryDTO.getId();
		this.code = commodityCategoryDTO.getCode();
		this.name = commodityCategoryDTO.getName();
		this.description = commodityCategoryDTO.getDescription();
		this.isActive = commodityCategoryDTO.getIsActive();
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
	
	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("CommodityCategory[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("code=").append(getCode()).append(",");
		newSB.append("name=").append(getName()).append(",");
		newSB.append("description=").append(getDescription()).append(",");
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
		
		if(obj instanceof CommodityCategory){
			CommodityCategory other = (CommodityCategory) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}
}
