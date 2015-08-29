/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.dto.FrieghtPlanDTO;
import com.cst6.msc.model.FrieghtPlan;
import com.cst6.msc.repo.FrieghtPlanRepository;
import com.cst6.msc.service.FrieghtPlanService;

/**
 * @author SasankaN
 *
 */
@Component("friegtPlanService")
@Transactional(readOnly = true)
public class DefaultFrieghtPlanService implements FrieghtPlanService {


	@Autowired
	private FrieghtPlanRepository frieghtPlanRepository;
	
	/**
	 * 
	 */
	@Override
	public List<FrieghtPlan> getAllFriegtPlans() {
		return frieghtPlanRepository.findAll();
	}

	/**
	 * 
	 */
	@Override
	public List<FrieghtPlan> getAllFriegtPlansAssignedToShip(Integer id) {
		return frieghtPlanRepository.findByShipId(id);
	}

	@Override
	public List<FrieghtPlan> searchAllFrieghtPlans(String searchData) {
		return frieghtPlanRepository.findByNameContaining(searchData);
	}

	@Transactional
	public void saveFrieghtPlan(FrieghtPlanDTO frieghtPlanDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFrieghtPlan(Integer id) {
		frieghtPlanRepository.delete(id);
	}

}
