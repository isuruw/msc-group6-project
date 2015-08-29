/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.dto.ShippingCompanyDTO;
import com.cst6.msc.model.Address;
import com.cst6.msc.model.ShippingCompany;
import com.cst6.msc.repo.AddressRepository;
import com.cst6.msc.repo.ShippingCompanyRepository;
import com.cst6.msc.service.AddressService;
import com.cst6.msc.service.CityService;
import com.cst6.msc.service.ShippingCompanyService;

/**
 * @author SasankaN
 *
 */
@Component
@Transactional(readOnly = true)
public class DefaultShippingCompanyService implements ShippingCompanyService {

	@Autowired
	private ShippingCompanyRepository shippingCompanyRepository;
	
	@Autowired
	private AddressRepository adderssRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private AddressService addressService;
	
	/**
	 * 
	 */
	@Override
	public List<ShippingCompany> getAllShippingCompanyies() {
		return shippingCompanyRepository.findAll();
	}

	/**
	 * 
	 */
	@Override
	public List<ShippingCompany> getAllShippingCompanies(Boolean boolean1) {
		return shippingCompanyRepository.findByIsActive(boolean1);
	}

	/**
	 * 
	 */
	@Override
	public List<ShippingCompany> searchAllShippingCompanies(String searchData) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public ShippingCompany getShippingCompanyById(Integer id) {
		return shippingCompanyRepository.findOne(id);
	}

	/**
	 * 
	 */
	@Override
	public void saveShippingCompany(ShippingCompanyDTO shippingCompanyDTO) {
		
		String addressStreetNo = shippingCompanyDTO.getStreetNo();
		String addressStreeName1 = shippingCompanyDTO.getStreetName1();
		String addressStreetName2 = shippingCompanyDTO.getStreetName2();
		Integer addressCityId = shippingCompanyDTO.getCityId();
				
		Address address = new Address();
		address.setStreetNo(addressStreetNo);
		address.setStreetName1(addressStreeName1);
		address.setStreetName2(addressStreetName2);
		address.setCity(cityService.getCityById(addressCityId));
		
		adderssRepository.saveAndFlush(address);
		
		Integer addressId = addressService.getSpecificAddress(addressStreetNo, addressStreeName1, addressStreetName2, addressCityId);
		
		ShippingCompany sc = new ShippingCompany(shippingCompanyDTO);
		sc.setAddress(addressService.getAddressById(addressId));
		
		shippingCompanyRepository.saveAndFlush(sc);
	}

	/**
	 * 
	 */
	@Override
	public void deleteShippingCompany(Integer id) {
		ShippingCompany shippingCompany = shippingCompanyRepository.findOne(id);
		Integer shippingAddressId = shippingCompany.getAddress().getId();
		shippingCompanyRepository.delete(id);
		adderssRepository.delete(shippingAddressId);
		
	}

}
