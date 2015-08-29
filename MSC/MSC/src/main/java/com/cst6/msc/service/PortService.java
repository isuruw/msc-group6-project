/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.dto.PortDTO;
import com.cst6.msc.model.Port;

/**
 * @author SasankaN
 *
 */
public interface PortService {

	List<Port> getAllPorts();
	
	Port getPortById(Integer id);
	
	List<Port> getAllPorts(Boolean booleanType);
	
	List<Port> searchAllPorts(String searchData);

	void savePort(PortDTO portDTO);

	void deletePort(Integer id);
	
}
