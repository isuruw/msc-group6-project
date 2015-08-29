/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.dto.FrieghtPlanPortDTO;
import com.cst6.msc.model.FrieghtPlanPort;

/**
 * @author SasankaN
 *
 */
public interface FrieghtPlanPortService {

	List<FrieghtPlanPort> getAllFrieghtPlanPorts();
	
	List<FrieghtPlanPort> getAllFrieghtPlanPorts(Boolean boolean1);
	
	List<FrieghtPlanPort> searchAllFrieghtPlanPorts(String searchData);

	FrieghtPlanPort findCommodityCategoryById(Integer id);

	void savFrieghtPlanPort(FrieghtPlanPortDTO frieghtPlanPortDTO);

	void deleteFrieghtPlanPort(Integer id);
}
