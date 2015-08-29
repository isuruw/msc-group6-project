/**
 * 
 */
package com.cst6.msc.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cst6.msc.dto.VisitingPortDTO;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name = "frieght_plan_port")
public class FrieghtPlanPort {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "port_order", nullable = false)
	private Integer portOrder;

	@Column(name = "expected_date_departure", nullable = false)
	private String expectedDateDeparture;

	@Column(name = "expected_time_arrival", nullable = false)
	private String expectedDateArrival;

	@ManyToOne
	@JoinColumn(name = "frieght_plan_id", referencedColumnName = "id")
	private FrieghtPlan frieghtPlan;

	@ManyToOne
	@JoinColumn(name = "port_id", referencedColumnName = "id")
	private Port port;

	public FrieghtPlanPort() {

	}

	/*public FrieghtPlanPort(RoutePortDTO routePortDTO) {
		this.id = routePortDTO.getId();
		this.portOrder = routePortDTO.getPortOrder();
		this.expectedDateDeparture = routePortDTO.getExpectedDateDeparture();
		this.expectedDateArrival = routePortDTO.getExpectedDateArrival();
	}*/
	
	public FrieghtPlanPort(VisitingPortDTO visitingPortDTO){
		this.portOrder = visitingPortDTO.getPortOrder();
		this.expectedDateArrival = visitingPortDTO.getExpectedTimeArrival();
		this.expectedDateDeparture = visitingPortDTO.getExpectedDateDeparture();
	}

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

	public String getExpectedDateDeparture() {
		return expectedDateDeparture;
	}

	public void setExpectedDateDeparture(String expectedDateDeparture) {
		this.expectedDateDeparture = expectedDateDeparture;
	}

	public String getExpectedDateArrival() {
		return expectedDateArrival;
	}

	public void setExpectedDateArrival(String expectedDateArrival) {
		this.expectedDateArrival = expectedDateArrival;
	}

	public FrieghtPlan getFriegtPlan() {
		return frieghtPlan;
	}

	public void setFriegtPlan(FrieghtPlan frieghtPlan) {
		this.frieghtPlan = frieghtPlan;
	}

	public Port getPort() {
		return port;
	}

	public void setPort(Port port) {
		this.port = port;
	}

	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("RoutePort[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("portOrder=").append(getPortOrder()).append(",");
		newSB.append("expectedDateDeparture=")
				.append(getExpectedDateDeparture()).append(",");
		newSB.append("expectedDateArrival=").append(getExpectedDateArrival())
				.append(",");
		newSB.append("friegthPlan=").append(getFriegtPlan()).append(",");
		newSB.append("port=").append(getPort());
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

		if (obj instanceof FrieghtPlanPort) {
			FrieghtPlanPort other = (FrieghtPlanPort) obj;
			return other.getId().equals(getId());
		}

		return false;
	}
}
