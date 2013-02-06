package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.dao.SubcategoryItemDao;

public class SubcategoryItemService {

	private SubcategoryItemDao subcategoryItemDao;

	public void setSubcategoryItemDao(SubcategoryItemDao subcategoryItemDao) {
		this.subcategoryItemDao = subcategoryItemDao;
	}

	public void update(Long itemId, List<Long> subCategoryIds) {
		subcategoryItemDao.deleteByItemId(itemId);
		for(Long subCategoryId : subCategoryIds){
			subcategoryItemDao.insert(itemId,subCategoryId);
		}
	}




}
