/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.dto.CustomerDTO;
import com.cst6.msc.model.Customer;

/**
 * @author SasankaN
 *
 */
public interface CustomerService {

	Customer getCustomerById(Integer id);

	List<Customer> getAllCustomers(Boolean boolean1);

	List<Customer> searchAllCustomers(String searchData);

	List<Customer> getAllCustomers();

	void saveCustomer(CustomerDTO customerDTO);

	void deleteCustomer(Integer id);
}
