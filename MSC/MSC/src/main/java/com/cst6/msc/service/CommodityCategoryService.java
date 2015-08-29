/**
 * 
 */
package com.cst6.msc.service;

import java.util.List;

import com.cst6.msc.dto.CommodityCategoryDTO;
import com.cst6.msc.model.CommodityCategory;

/**
 * @author SasankaN
 *
 */
public interface CommodityCategoryService {

	List<CommodityCategory> getAllCommodityCategories();
	
	List<CommodityCategory> getAllCommodityCategories(Boolean boolean1);
	
	List<CommodityCategory> searchAllCommodityCategories(String searchData);

	CommodityCategory findCommodityCategoryById(Integer id);

	void saveCommodityCategory(CommodityCategoryDTO commodityCategoryDTO);

	void deleteCommodityCategory(Integer id);
}
