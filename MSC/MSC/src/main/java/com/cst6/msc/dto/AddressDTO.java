/**
 * 
 */
package com.cst6.msc.dto;


/**
 * @author SasankaN
 *
 */
public class AddressDTO {

	private Integer id;
	
	private String streetNo;
	
	private String streetName1;
	
	private String streetName2;
	
	private Integer cityId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getStreetName1() {
		return streetName1;
	}

	public void setStreetName1(String streetName1) {
		this.streetName1 = streetName1;
	}

	public String getStreetName2() {
		return streetName2;
	}

	public void setStreetName2(String streetName2) {
		this.streetName2 = streetName2;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	
	
}
