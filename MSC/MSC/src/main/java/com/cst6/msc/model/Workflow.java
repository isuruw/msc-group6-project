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

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="workflow")
public class Workflow {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="state", nullable=false)
	private String state;
	
	@Column(name="value", nullable=false)
	private String value;
	
	@Column(name="updated_username")
	private String updatedUsername;
	
	@Column(name="updated_date")
	private Date updatedDate;
	
	@ManyToOne
	@JoinColumn(name="booking_id", referencedColumnName="id")
	private Booking booking;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getUpdatedUsername() {
		return updatedUsername;
	}

	public void setUpdatedUsername(String updatedUsername) {
		this.updatedUsername = updatedUsername;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	public String toString() {
		StringBuilder newSB = new StringBuilder("Workflow[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("state=").append(getState()).append(",");
		newSB.append("value=").append(getValue()).append(",");
		newSB.append("updatedUsername=").append(getUpdatedUsername()).append(",");
		newSB.append("updatedDate=").append(getUpdatedDate()).append(",");
		newSB.append("booking=").append(getBooking());
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
		
		if(obj instanceof Workflow){
			Workflow other = (Workflow) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}
}
