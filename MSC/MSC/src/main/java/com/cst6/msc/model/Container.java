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

import com.cst6.msc.dto.ContainerDTO;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name = "container")
public class Container {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive;

	@ManyToOne
	@JoinColumn(name = "container_type_id", referencedColumnName = "id")
	private ContainerType containerType;

	@ManyToOne
	@JoinColumn(name = "shipping_company_id", referencedColumnName = "id")
	private ShippingCompany shippingCompany;

	@ManyToOne
	@JoinColumn(name = "frieght_plan_id", referencedColumnName = "id")
	private FrieghtPlan frieghtPlan;

	public Container() {

	}

	public Container(ContainerDTO containerDTO) {
		this.id = containerDTO.getId();
		this.code = containerDTO.getCode();
		this.name = containerDTO.getName();
		this.isActive = containerDTO.getIsActive();
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public ContainerType getContainerType() {
		return containerType;
	}

	public void setContainerType(ContainerType containerType) {
		this.containerType = containerType;
	}

	public ShippingCompany getShippingCompany() {
		return shippingCompany;
	}

	public void setShippingCompany(ShippingCompany shippingCompany) {
		this.shippingCompany = shippingCompany;
	}

	public FrieghtPlan getFriegtPlan() {
		return frieghtPlan;
	}

	public void setFriegtPlan(FrieghtPlan frieghtPlan) {
		this.frieghtPlan = frieghtPlan;
	}

	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("Container[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("code=").append(getCode()).append(",");
		newSB.append("name=").append(getName()).append(",");
		newSB.append("isActive=").append(getIsActive()).append(",");
		newSB.append("containerType=").append(getContainerType()).append(",");
		newSB.append("shippingCompany=").append(getShippingCompany())
				.append(",");
		newSB.append("frieghtPlan=").append(getFriegtPlan());
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

		if (obj == this)
			return true;

		if (obj instanceof Container) {
			Container other = (Container) obj;
			return other.getId().equals(getId());
		}

		return false;
	}
}
