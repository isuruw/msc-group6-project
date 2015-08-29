/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.dto.ShipDTO;
import com.cst6.msc.model.Ship;
import com.cst6.msc.repo.ShipRepository;
import com.cst6.msc.service.ShipCategoryService;
import com.cst6.msc.service.ShipService;
import com.cst6.msc.service.ShippingCompanyService;

/**
 * @author SasankaN
 *
 */
@Component("shipService")
@Transactional
public class DefaultShipService implements ShipService {

	@Autowired
	private ShipRepository shipRepository;

	@Autowired
	private ShipCategoryService shipCategoryService;

	@Autowired
	private ShippingCompanyService shippingCompanyService;

	/**
	 * 
	 */
	@Override
	public List<Ship> getAllShips() {
		return shipRepository.findAll();
	}

	/**
	 * 
	 */
	@Override
	public Ship getShipById(Integer shipid) {
		return shipRepository.findOne(shipid);
	}

	/**
	 * 
	 */
	@Override
	public List<Ship> getAllShips(Boolean booleanType) {
		return shipRepository.findByIsActive(booleanType);
	}

	@Override
	public List<Ship> searchAllShips(String searchData) {
		return shipRepository.findByNameContaining(searchData);
	}

	/**
	 * 
	 */
	@Transactional
	public void saveShip(ShipDTO shipDTO) {
		Ship ship = new Ship(shipDTO);
		ship.setShipCategory(shipCategoryService.getShipCategoryById(shipDTO
				.getShipCategoryId()));
		ship.setShippingCompany(shippingCompanyService
				.getShippingCompanyById(shipDTO.getShippingCompanyId()));
		
		shipRepository.saveAndFlush(ship);
	}

	/**
	 * 
	 */
	@Override
	public void deleteShip(Integer id) {
		shipRepository.delete(id);
	}

}
