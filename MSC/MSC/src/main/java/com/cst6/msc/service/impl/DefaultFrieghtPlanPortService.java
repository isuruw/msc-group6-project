/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.dto.FrieghtPlanPortDTO;
import com.cst6.msc.dto.VisitingPortDTO;
import com.cst6.msc.model.FrieghtPlan;
import com.cst6.msc.model.FrieghtPlanPort;
import com.cst6.msc.repo.FrieghtPlanPortRepository;
import com.cst6.msc.repo.FrieghtPlanRepository;
import com.cst6.msc.service.FrieghtPlanPortService;
import com.cst6.msc.service.PortService;
import com.cst6.msc.service.ShipService;

/**
 * @author SasankaN
 *
 */
@Component("frieghtPlanPortService")
@Transactional(readOnly = true)
public class DefaultFrieghtPlanPortService implements FrieghtPlanPortService {

	@Autowired
	private FrieghtPlanPortRepository frieghtPlanPortRepository;
	
	@Autowired
	private ShipService shipService;
	
	@Autowired
	private FrieghtPlanRepository frieghtPlanRepository;
	
	@Autowired
	private PortService portService;
	
	/**
	 * 
	 */
	@Override
	public List<FrieghtPlanPort> getAllFrieghtPlanPorts() {
		return frieghtPlanPortRepository.findAll();
	}

	/**
	 * 
	 */
	@Override
	public List<FrieghtPlanPort> getAllFrieghtPlanPorts(Boolean boolean1) {
		return null;
	}

	/**
	 * 
	 */
	@Override
	public List<FrieghtPlanPort> searchAllFrieghtPlanPorts(String searchData) {
		return null;
	}

	/**
	 * 
	 */
	@Override
	public FrieghtPlanPort findCommodityCategoryById(Integer id) {
		return frieghtPlanPortRepository.findOne(id);
	}

	/**
	 * 
	 */
	@Transactional
	public void savFrieghtPlanPort(FrieghtPlanPortDTO frieghtPlanPortDTO) {
		FrieghtPlan fp = new FrieghtPlan(frieghtPlanPortDTO);
		fp.setDeparturePortId(portService.getPortById(frieghtPlanPortDTO.getDeparturePortId()));
		fp.setDestinationPortId(portService.getPortById(frieghtPlanPortDTO.getDestinationPortId()));
		fp.setShip(shipService.getShipById(frieghtPlanPortDTO.getShipId()));
		
		FrieghtPlan savedFrieghtPlan = frieghtPlanRepository.saveAndFlush(fp);
		
		List<FrieghtPlanPort> ports = new ArrayList<FrieghtPlanPort>();
		
		for (VisitingPortDTO visitingPort : frieghtPlanPortDTO.getVistingPortList()) {
			FrieghtPlanPort fpp = new FrieghtPlanPort(visitingPort);
			fpp.setFriegtPlan(savedFrieghtPlan);
			fpp.setPort(portService.getPortById(visitingPort.getPortId()));
			
			FrieghtPlanPort savedFrieghtPlanPort = frieghtPlanPortRepository.saveAndFlush(fpp);
			ports.add(savedFrieghtPlanPort);
		}
		
		
		

	}

	/**
	 * 
	 */
	@Override
	public void deleteFrieghtPlanPort(Integer id) {
		frieghtPlanPortRepository.delete(id);
	}

}
