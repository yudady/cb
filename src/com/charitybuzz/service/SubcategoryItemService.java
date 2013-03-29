package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.dao.SubcategoryItemDao;

/**
 * 二級目錄與商品的中間表
 * 
 * @author Administrator
 * 
 */
public class SubcategoryItemService {

	private SubcategoryItemDao subcategoryItemDao;

	public void setSubcategoryItemDao(SubcategoryItemDao subcategoryItemDao) {
		this.subcategoryItemDao = subcategoryItemDao;
	}

	/**
	 * insert
	 * 
	 * @param itemId
	 * @param subCategoryIds
	 */
	public void insert(Long itemId, List<Long> subCategoryIds) {
		for (Long subCategoryId : subCategoryIds) {
			subcategoryItemDao.insert(itemId, subCategoryId);
		}
	}

	/**
	 * update
	 * 
	 * @param itemId
	 * @param subCategoryIds
	 */
	public void update(Long itemId, List<Long> subCategoryIds) {
		this.delete(itemId);
		this.insert(itemId, subCategoryIds);
	}

	/**
	 * delete
	 * 
	 * @param itemId
	 */
	public void delete(Long itemId) {
		subcategoryItemDao.deleteByItemId(itemId);
	}

}
