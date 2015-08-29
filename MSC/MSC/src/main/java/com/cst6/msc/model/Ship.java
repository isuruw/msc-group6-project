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

import com.cst6.msc.dto.ShipDTO;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="ship")
public class Ship {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="imo_no", nullable=false)
	private String imoNo;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="gross_register_tonnage", nullable=false)
	private Double grossRegisterTonnage;
	
	@Column(name="net_register_tonnage", nullable=false)
	private Double netRegisterTonnage;
	
	@Column(name="is_active", nullable=false)
	private Boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="ship_category_id", referencedColumnName="id")
	private ShipCategory shipCategory;
	
	@ManyToOne
	@JoinColumn(name="shipping_company_id", referencedColumnName="id")
	private ShippingCompany shippingCompany;

	public Ship(){
		
	}
	
	public Ship(ShipDTO shipDTO){
		this.id = shipDTO.getId();
		this.imoNo = shipDTO.getImoNo();
		this.name = shipDTO.getName();
		this.grossRegisterTonnage = shipDTO.getGrossRegisterTonnage();
		this.netRegisterTonnage = shipDTO.getNetRegisterTonnage();
		this.isActive = shipDTO.getIsActive();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImoNo() {
		return imoNo;
	}

	public void setImoNo(String imoNo) {
		this.imoNo = imoNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getGrossRegisterTonnage() {
		return grossRegisterTonnage;
	}

	public void setGrossRegisterTonnage(Double grossRegisterTonnage) {
		this.grossRegisterTonnage = grossRegisterTonnage;
	}

	public Double getNetRegisterTonnage() {
		return netRegisterTonnage;
	}

	public void setNetRegisterTonnage(Double netRegisterTonnage) {
		this.netRegisterTonnage = netRegisterTonnage;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public ShipCategory getShipCategory() {
		return shipCategory;
	}

	public void setShipCategory(ShipCategory shipCategory) {
		this.shipCategory = shipCategory;
	}

	public ShippingCompany getShippingCompany() {
		return shippingCompany;
	}

	public void setShippingCompany(ShippingCompany shippingCompany) {
		this.shippingCompany = shippingCompany;
	}
	
	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("Ship[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("imoNo=").append(getImoNo()).append(",");
		newSB.append("name=").append(getName()).append(",");
		newSB.append("grossRegisterTonnage=").append(getGrossRegisterTonnage()).append(",");
		newSB.append("netRegisterTonnage=").append(getNetRegisterTonnage()).append(",");
		newSB.append("isActive=").append(getIsActive()).append(",");
		newSB.append("shipCategory=").append(getShipCategory()).append(",");
		newSB.append("shippingCompany=").append(getShippingCompany());
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
		
		if(obj instanceof Ship){
			Ship other = (Ship) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}
	
	
	
}
