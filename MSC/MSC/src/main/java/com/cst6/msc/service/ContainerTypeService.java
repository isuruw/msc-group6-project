/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.model.ContainerType;

/**
 * @author SasankaN
 *
 */
public interface ContainerTypeService {

	List<ContainerType> getAllContainerTypes();

	ContainerType getContainerTypeById(Integer id);
}
