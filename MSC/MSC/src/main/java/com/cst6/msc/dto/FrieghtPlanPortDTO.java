/**
 * 
 */
package com.cst6.msc.dto;

import java.util.List;

/**
 * @author SasankaN
 *
 */
public class FrieghtPlanPortDTO {
	
	private Integer id;

	private String code;
	
	private String name;
	
	private Integer shipId;
	
	private Integer departurePortId;
	
	private String departurePortTime;
	
	private Integer destinationPortId;
	
	private String destinationPortTime;
	
	private List<VisitingPortDTO> vistingPortList;

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

	public Integer getDeparturePortId() {
		return departurePortId;
	}

	public void setDeparturePortId(Integer departurePortId) {
		this.departurePortId = departurePortId;
	}

	public String getDeparturePortTime() {
		return departurePortTime;
	}

	public void setDeparturePortTime(String departurePortTime) {
		this.departurePortTime = departurePortTime;
	}

	public Integer getDestinationPortId() {
		return destinationPortId;
	}

	public void setDestinationPortId(Integer destinationPortId) {
		this.destinationPortId = destinationPortId;
	}

	public String getDestinationPortTime() {
		return destinationPortTime;
	}

	public void setDestinationPortTime(String destinationPortTime) {
		this.destinationPortTime = destinationPortTime;
	}

	public List<VisitingPortDTO> getVistingPortList() {
		return vistingPortList;
	}

	public void setVistingPortList(List<VisitingPortDTO> vistingPortList) {
		this.vistingPortList = vistingPortList;
	}

	
}
