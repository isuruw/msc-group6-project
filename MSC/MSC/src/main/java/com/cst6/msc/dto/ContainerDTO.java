/**
 * 
 */
package com.cst6.msc.dto;



/**
 * @author SasankaN
 *
 */
public class ContainerDTO {

	private Integer id;
	
	private String code;
	
	private String name;
	
	private Boolean isActive;
	
	private Integer containerTypeId;
	
	private Integer shippingCompanyId;
	
	private Integer frieghtPlanId;

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

	public Integer getContainerTypeId() {
		return containerTypeId;
	}

	public void setContainerTypeId(Integer containerTypeId) {
		this.containerTypeId = containerTypeId;
	}

	public Integer getShippingCompanyId() {
		return shippingCompanyId;
	}

	public void setShippingCompanyId(Integer shippingCompanyId) {
		this.shippingCompanyId = shippingCompanyId;
	}

	public Integer getFrieghtPlanId() {
		return frieghtPlanId;
	}

	public void setFrieghtPlanId(Integer frieghtPlanId) {
		this.frieghtPlanId = frieghtPlanId;
	}
	
	
}
