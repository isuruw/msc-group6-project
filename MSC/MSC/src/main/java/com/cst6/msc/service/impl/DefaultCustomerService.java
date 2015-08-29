/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.dto.CustomerDTO;
import com.cst6.msc.model.Customer;
import com.cst6.msc.repo.CustomerRepository;
import com.cst6.msc.service.CustomerService;

/**
 * @author SasankaN
 *
 */
@Component("customerService")
@Transactional(readOnly = true)
public class DefaultCustomerService implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	/**
	 * 
	 */
	@Override
	public Customer getCustomerById(Integer id) {
		return customerRepository.findOne(id);
	}

	/**
	 * 
	 */
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	/**
	 * 
	 */
	@Transactional
	public void saveCustomer(CustomerDTO customerDTO) {
		Customer c = new Customer(customerDTO);
		///		
		
		customerRepository.saveAndFlush(c);
	}

	/**
	 * 
	 */
	@Override
	public void deleteCustomer(Integer id) {
		customerRepository.delete(id);

	}

	@Override
	public List<Customer> getAllCustomers(Boolean boolean1) {
		return customerRepository.findByIsActive(boolean1);
	}

	@Override
	public List<Customer> searchAllCustomers(String searchData) {
		return customerRepository.findByBusinessNameContaining(searchData);
	}

}
