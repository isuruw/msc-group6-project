/**
 * 
 */
package com.cst6.msc.dto;

import java.util.Date;

/**
 * @author SasankaN
 *
 */
public class VisitingPortDTO {

	private Integer id;
	
	private Integer portId;
	
	private Integer portOrder;
	
	private String expectedDateDeparture;
	
	private String expectedTimeArrival;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPortId() {
		return portId;
	}

	public void setPortId(Integer portId) {
		this.portId = portId;
	}
	
	public Integer getPortOrder() {
		return portOrder;
	}

	public void setPortOrder(Integer portOrder) {
		this.portOrder = portOrder;
	}

	public String getExpectedDateDeparture() {
		return expectedDateDeparture;
	}

	public void setExpectedDateDeparture(String expectedDateDeparture) {
		this.expectedDateDeparture = expectedDateDeparture;
	}

	public String getExpectedTimeArrival() {
		return expectedTimeArrival;
	}

	public void setExpectedTimeArrival(String expectedTimeArrival) {
		this.expectedTimeArrival = expectedTimeArrival;
	}
	
	
}
