/**
 * 
 */
package com.cst6.msc.dto;

/**
 * @author SasankaN
 *
 */
public class FrieghtPlanDTO {

	private Integer id;
	
	private String code;
	
	private String name;
	
	private Integer shipId;

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

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}
	
	
}
