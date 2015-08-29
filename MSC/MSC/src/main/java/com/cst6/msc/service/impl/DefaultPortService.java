/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.dto.PortDTO;
import com.cst6.msc.model.Port;
import com.cst6.msc.repo.PortRepository;
import com.cst6.msc.service.CityService;
import com.cst6.msc.service.PortService;

/**
 * @author SasankaN
 *
 */
@Component("portService")
@Transactional(readOnly = true)
public class DefaultPortService implements PortService {

	@Autowired
	private PortRepository portRepository;
	
	@Autowired
	private CityService cityService;
	
	/**
	 * 
	 */
	@Override
	public List<Port> getAllPorts() {
		return portRepository.findAll();
	}

	/**
	 * 
	 */
	@Override
	public Port getPortById(Integer id) {
		return portRepository.findOne(id);
	}

	@Override
	public List<Port> getAllPorts(Boolean booleanType) {
		return portRepository.findByIsActive(booleanType);
	}

	@Override
	public List<Port> searchAllPorts(String searchData) {
		return portRepository.findByNameContaining(searchData);
	}

	@Transactional
	public void savePort(PortDTO portDTO) {
		Port p = new Port(portDTO);
		p.setCity(cityService.getCityById(portDTO.getCityId()));
		
		portRepository.saveAndFlush(p);
	}

	@Override
	public void deletePort(Integer id) {
		portRepository.delete(id);
	}

}
