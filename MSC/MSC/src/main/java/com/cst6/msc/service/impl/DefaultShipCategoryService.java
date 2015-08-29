/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.model.ShipCategory;
import com.cst6.msc.repo.ShipCategoryRepository;
import com.cst6.msc.service.ShipCategoryService;

/**
 * @author SasankaN
 *
 */
@Component("shipCategoryService")
@Transactional(readOnly = true)
public class DefaultShipCategoryService implements ShipCategoryService {

	@Autowired
	private ShipCategoryRepository shipCategoryRepository;
	/**
	 * 
	 */
	@Override
	public List<ShipCategory> getAllShipCategories() {
		return shipCategoryRepository.findAll();
	}

	/**
	 * 
	 */
	@Override
	public ShipCategory getShipCategoryById(Integer id) {
		return shipCategoryRepository.findOne(id);
	}

	/**
	 * 
	 */
	@Override
	public List<ShipCategory> searchAllShipCategories(String searchData) {
		return shipCategoryRepository.findByTypeContaining(searchData);
	}

	/**
	 * 
	 */
	@Override
	public void saveShipCategory(ShipCategory shipCategory) {
		shipCategoryRepository.saveAndFlush(shipCategory);
	}

	/**
	 * 
	 */
	@Override
	public void deleteShipCategory(Integer id) {
		shipCategoryRepository.delete(id);
	}

}
