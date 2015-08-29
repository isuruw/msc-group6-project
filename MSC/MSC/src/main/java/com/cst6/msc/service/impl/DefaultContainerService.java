/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.dto.ContainerDTO;
import com.cst6.msc.model.Container;
import com.cst6.msc.repo.ContainerRepository;
import com.cst6.msc.repo.ContainerTypeRepository;
import com.cst6.msc.repo.ShippingCompanyRepository;
import com.cst6.msc.service.ContainerService;

/**
 * @author SasankaN
 *
 */
@Component("containerService")
@Transactional(readOnly = true)
public class DefaultContainerService implements ContainerService{

	@Autowired
	private ContainerRepository containerRepository;
	
	@Autowired
	private ContainerTypeRepository containerTypeRepository;
	
	@Autowired
	private ShippingCompanyRepository shippingCompanyRepository;
	
	@Override
	public List<Container> getAllContainers() {
		return containerRepository.findAll();
	}

	@Override
	public List<Container> getAllContainers(Boolean boolean1) {
		return containerRepository.findByIsActive(boolean1);
	}

	@Override
	public List<Container> searchAllContainers(String searchData) {
		return containerRepository.findByNameContaining(searchData);
	}

	@Override
	public Container findContainerById(Integer id) {
		return containerRepository.findOne(id);
	}

	@Transactional
	public void saveContainer(ContainerDTO containerDTO) {
		Container c = new Container(containerDTO);
		c.setContainerType(containerTypeRepository.findOne(containerDTO.getContainerTypeId()));
		c.setShippingCompany(shippingCompanyRepository.findOne(containerDTO.getShippingCompanyId()));
		//c.getFriegtPlan();
		
		containerRepository.saveAndFlush(c);
		
	}

	@Override
	public void deleteContainer(Integer id) {
		containerRepository.delete(id);
	}

}
