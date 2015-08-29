/**
 * 
 */
package com.cst6.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cst6.msc.dto.CommodityCategoryDTO;
import com.cst6.msc.model.CommodityCategory;
import com.cst6.msc.repo.CommodityCategoryRepository;
import com.cst6.msc.service.CommodityCategoryService;

/**
 * @author SasankaN
 *
 */
@Component("commodityCategoryService")
@Transactional(readOnly = true)
public class DefaultCommodityCategoryService implements
		CommodityCategoryService {

	@Autowired
	private CommodityCategoryRepository commodityCategoryRepository;
	
	/**
	 * 
	 */
	@Override
	public List<CommodityCategory> getAllCommodityCategories() {
		return commodityCategoryRepository.findAll();
	}

	/**
	 * 
	 */
	@Override
	public CommodityCategory findCommodityCategoryById(Integer id) {
		return commodityCategoryRepository.findOne(id);
	}

	@Transactional
	public void saveCommodityCategory(CommodityCategoryDTO commodityCategoryDTO) {
		CommodityCategory cc = new CommodityCategory(commodityCategoryDTO);
		commodityCategoryRepository.saveAndFlush(cc);
	}

	@Override
	public void deleteCommodityCategory(Integer id) {
		commodityCategoryRepository.delete(id);
	}

	@Override
	public List<CommodityCategory> getAllCommodityCategories(Boolean booleanType) {
		return commodityCategoryRepository.findByIsActive(booleanType);
	}

	@Override
	public List<CommodityCategory> searchAllCommodityCategories(
			String searchData) {
		return commodityCategoryRepository.findByNameContaining(searchData);
	}

}
