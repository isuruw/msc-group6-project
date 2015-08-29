/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.dto.AddressDTO;
import com.cst6.msc.model.Address;
import com.cst6.msc.repo.AddressRepository;
import com.cst6.msc.service.AddressService;
import com.cst6.msc.service.CityService;

/**
 * @author SasankaN
 *
 */
@Component("addressService")
@Transactional(readOnly = true)
public class DefaultAddressService implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CityService cityService;
	
	/**
	 * 
	 */
	@Override
	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

	/**
	 * 
	 */
	@Override
	public List<Address> searchAllAddresses(String searchData) {
		return addressRepository.findByStreetNoContaining(searchData);
	}

	/**
	 * 
	 */
	@Override
	public Address getAddressById(Integer id) {
		return addressRepository.findOne(id);
	}

	/**
	 * 
	 */
	@Override
	public void saveAddress(AddressDTO addressDTO) {
		Address address = new Address(addressDTO);
		address.setCity(cityService.getCityById(addressDTO.getCityId()));
		
		addressRepository.saveAndFlush(address);
	}

	/**
	 * 
	 */
	@Override
	public void deleteAddress(Integer id) {
		addressRepository.delete(id);
	}

	/**
	 * 
	 */
	@Override
	public Integer getSpecificAddress(String streetNo, String streetName1,
			String streetName2, Integer cityId) {
		Address searchAddress = addressRepository.findByStreetNoAndStreetName1AndStreetName2AndCityId(streetNo, streetName1, streetName2, cityId);
		
		if(searchAddress != null)
			return searchAddress.getId();
		
		return null;
	}

}
