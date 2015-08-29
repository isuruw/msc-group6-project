/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.model.ShipCategory;

/**
 * @author SasankaN
 *
 */
public interface ShipCategoryService {

	List<ShipCategory> getAllShipCategories();

	ShipCategory getShipCategoryById(Integer id);

	List<ShipCategory> searchAllShipCategories(String searchData);

	void saveShipCategory(ShipCategory shipCategory);

	void deleteShipCategory(Integer id);
}
