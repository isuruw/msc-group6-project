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

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="commodity")
public class Commodity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="width", nullable=false)
	private Float width;
	
	@Column(name="height", nullable=false)
	private Float height;
	
	@Column(name="weight", nullable=false)
	private Float weight;
	
	@Column(name="quantity", nullable=false)
	private Float quantity;
	
	@Column(name="is_hazardous", nullable=false)
	private Boolean isHazardous;
	
	@ManyToOne
	@JoinColumn(name="commodity_category_id", referencedColumnName="id")
	private CommodityCategory commodityCategory;
	
	@ManyToOne
	@JoinColumn(name="booking_id", referencedColumnName="id")
	private Booking booking;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public Boolean getIsHazardous() {
		return isHazardous;
	}

	public void setIsHazardous(Boolean isHazardous) {
		this.isHazardous = isHazardous;
	}

	public CommodityCategory getCommodityCategory() {
		return commodityCategory;
	}

	public void setCommodityCategory(CommodityCategory commodityCategory) {
		this.commodityCategory = commodityCategory;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("Commodity[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("name=").append(getName()).append(",");
		newSB.append("width=").append(getName()).append(",");
		newSB.append("heigt=").append(getName()).append(",");
		newSB.append("weight=").append(getName()).append(",");
		newSB.append("quantity=").append(getName()).append(",");
		newSB.append("isHazardous=").append(getName()).append(",");
		newSB.append("commodityCategory=").append(getName()).append(",");
		newSB.append("booking=").append(getName());
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
		
		if(obj instanceof Commodity){
			Commodity other = (Commodity) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}
	
	
}
