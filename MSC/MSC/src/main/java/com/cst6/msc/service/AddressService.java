/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.dto.AddressDTO;
import com.cst6.msc.model.Address;

/**
 * @author SasankaN
 *
 */
public interface AddressService {

	List<Address> getAllAddresses();

	List<Address> searchAllAddresses(String searchData);

	Address getAddressById(Integer id);
	
	void saveAddress(AddressDTO addressDTO);

	void deleteAddress(Integer id);
	
	Integer getSpecificAddress(String streetNo, String streetName1, String streetName2, Integer cityId);
}
