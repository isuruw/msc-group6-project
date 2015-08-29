/**
 * 
 */
package com.cst6.msc.dto;

import java.util.Date;

/**
 * @author SasankaN
 *
 */
public class RoutePortDTO {

	private Integer id;
	
	private Integer portOrder;
	
	private Date expectedDateDeparture;
	
	private Date expectedDateArrival;
	
	private Integer routeId;
	
	private Integer portId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPortOrder() {
		return portOrder;
	}

	public void setPortOrder(Integer portOrder) {
		this.portOrder = portOrder;
	}

	public Date getExpectedDateDeparture() {
		return expectedDateDeparture;
	}

	public void setExpectedDateDeparture(Date expectedDateDeparture) {
		this.expectedDateDeparture = expectedDateDeparture;
	}

	public Date getExpectedDateArrival() {
		return expectedDateArrival;
	}

	public void setExpectedDateArrival(Date expectedDateArrival) {
		this.expectedDateArrival = expectedDateArrival;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Integer getPortId() {
		return portId;
	}

	public void setPortId(Integer portId) {
		this.portId = portId;
	}
	
	
}
