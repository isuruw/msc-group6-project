/**
 * 
 */
package com.cst6.msc.dto;


/**
 * @author SasankaN
 *
 */
public class ShipDTO {

	private Integer id;
	
	private String imoNo;
	
	private String name;
	
	private Double grossRegisterTonnage;
	
	private Double netRegisterTonnage;
	
	private Boolean isActive;
	
	private Integer shipCategoryId;
	
	private Integer shippingCompanyId;

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

	public Integer getShipCategoryId() {
		return shipCategoryId;
	}

	public void setShipCategoryId(Integer shipCategoryId) {
		this.shipCategoryId = shipCategoryId;
	}

	public Integer getShippingCompanyId() {
		return shippingCompanyId;
	}

	public void setShippingCompanyId(Integer shippingCompanyId) {
		this.shippingCompanyId = shippingCompanyId;
	}
	
	
}
