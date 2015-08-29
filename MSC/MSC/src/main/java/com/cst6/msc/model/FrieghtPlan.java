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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cst6.msc.dto.FrieghtPlanPortDTO;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="frieght_plan")
public class FrieghtPlan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="code", nullable=false)
	private String code;
	
	@Column(name="name")
	private String name;
	
	@OneToOne
	@JoinColumn(name="departure_port_id")
	private Port departurePortId;
	
	@Column(name="departure_port_time")
	private String departurePortTime;
	
	@OneToOne
	@JoinColumn(name="destination_port_id")
	private Port destinationPortId;
	
	@Column(name="destination_port_time")
	private String destinationPortTime;
	
	@ManyToOne
	@JoinColumn(name = "ship_id", referencedColumnName = "id")
	private Ship ship;
	
	public FrieghtPlan(){
		
	}
	
	public FrieghtPlan(FrieghtPlanPortDTO frieghtPlanPortDTO){
		this.code = frieghtPlanPortDTO.getCode();
		this.name = frieghtPlanPortDTO.getName();
		this.departurePortTime = frieghtPlanPortDTO.getDeparturePortTime();
		this.destinationPortTime = frieghtPlanPortDTO.getDestinationPortTime();
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

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	public Port getDeparturePortId() {
		return departurePortId;
	}

	public void setDeparturePortId(Port departurePortId) {
		this.departurePortId = departurePortId;
	}

	public String getDeparturePortTime() {
		return departurePortTime;
	}

	public void setDeparturePortTime(String departurePortTime) {
		this.departurePortTime = departurePortTime;
	}

	public Port getDestinationPortId() {
		return destinationPortId;
	}

	public void setDestinationPortId(Port destinationPortId) {
		this.destinationPortId = destinationPortId;
	}

	public String getDestinationPortTime() {
		return destinationPortTime;
	}

	public void setDestinationPortTime(String destinationPortTime) {
		this.destinationPortTime = destinationPortTime;
	}

	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("FrieghtPlan[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("code=").append(getCode()).append(",");
		newSB.append("name=").append(getName()).append(",");
		newSB.append("ship=").append(getShip());
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
		
		if(obj instanceof FrieghtPlan){
			FrieghtPlan other = (FrieghtPlan) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}

}
