/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.model.ContainerType;
import com.cst6.msc.repo.ContainerTypeRepository;
import com.cst6.msc.service.ContainerTypeService;

/**
 * @author SasankaN
 *
 */
@Component("containerTypeService")
@Transactional(readOnly = true)
public class DefaultContainerTypeService implements ContainerTypeService{

	@Autowired
	private ContainerTypeRepository containerTypeRepository;

	@Override
	public List<ContainerType> getAllContainerTypes() {
		return containerTypeRepository.findAll();
	}

	@Override
	public ContainerType getContainerTypeById(Integer id) {
		return containerTypeRepository.findOne(id);
	}
	
	

}
