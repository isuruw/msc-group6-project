/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.dto.ShippingCompanyDTO;
import com.cst6.msc.model.ShippingCompany;

/**
 * @author SasankaN
 *
 */
public interface ShippingCompanyService {

	List<ShippingCompany> getAllShippingCompanyies();

	List<ShippingCompany> getAllShippingCompanies(Boolean boolean1);

	List<ShippingCompany> searchAllShippingCompanies(String searchData);

	ShippingCompany getShippingCompanyById(Integer id);

	void saveShippingCompany(ShippingCompanyDTO shippingCompanyDTO);

	void deleteShippingCompany(Integer id);
}
