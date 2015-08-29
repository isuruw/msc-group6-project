/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.dto.ShipDTO;
import com.cst6.msc.model.Ship;

/**
 * @author SasankaN
 *
 */
public interface ShipService {

	List<Ship> getAllShips();

	Ship getShipById(Integer id);

	List<Ship> getAllShips(Boolean booleanType);

	List<Ship> searchAllShips(String searchData);

	void saveShip(ShipDTO shipDTO);

	void deleteShip(Integer id);

}
