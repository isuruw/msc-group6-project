/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.dto.ContainerDTO;
import com.cst6.msc.model.Container;

/**
 * @author SasankaN
 *
 */
public interface ContainerService {

	List<Container> getAllContainers();
	
	List<Container> getAllContainers(Boolean boolean1);
	
	List<Container> searchAllContainers(String searchData);

	Container findContainerById(Integer id);

	void saveContainer(ContainerDTO containerDTO);

	void deleteContainer(Integer id);
}
