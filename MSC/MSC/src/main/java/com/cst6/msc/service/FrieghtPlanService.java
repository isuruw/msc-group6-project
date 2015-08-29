/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.dto.FrieghtPlanDTO;
import com.cst6.msc.model.FrieghtPlan;

/**
 * @author SasankaN
 *
 */
public interface FrieghtPlanService {

	List<FrieghtPlan> getAllFriegtPlans();

	List<FrieghtPlan> getAllFriegtPlansAssignedToShip(Integer id);

	List<FrieghtPlan> searchAllFrieghtPlans(String searchData);

	void saveFrieghtPlan(FrieghtPlanDTO frieghtPlanDTO);

	void deleteFrieghtPlan(Integer id);
}
