package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.dao.SubcategoryItemDao;

public class SubcategoryItemService {

	private SubcategoryItemDao subcategoryItemDao;

	public void setSubcategoryItemDao(SubcategoryItemDao subcategoryItemDao) {
		this.subcategoryItemDao = subcategoryItemDao;
	}

	public void insert(Long itemId, List<Long> subCategoryIds) {
		for (Long subCategoryId : subCategoryIds) {
			subcategoryItemDao.insert(itemId, subCategoryId);
		}
	}

	public void update(Long itemId, List<Long> subCategoryIds) {
		this.delete(itemId);
		this.insert(itemId, subCategoryIds);
	}

	public void delete(Long itemId) {
		subcategoryItemDao.deleteByItemId(itemId);
	}

}
