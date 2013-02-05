package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.dao.SubCategoryDao;
import com.charitybuzz.dto.SubCategory;

public class SubCategoryService {

	private SubCategoryDao subCategoryDao;

	public void setSubCategoryDao(SubCategoryDao subCategoryDao) {
		this.subCategoryDao = subCategoryDao;
	}

	/**
	 * 用一級目錄id 找出全部二級目錄的商品
	 * 
	 * @return
	 */
	public List<SubCategory> findByCategoryId(Long categoryId) {
		return subCategoryDao.findByCategoryId(categoryId);
	}

	public List<SubCategory> findAll() {
		return subCategoryDao.findAll();
	}

	public void insert(SubCategory subCategory) {
		subCategoryDao.insert(subCategory);

	}

	public SubCategory findById(Long subCategoryId) {
		return subCategoryDao.findById(subCategoryId);
	}

	public void update(SubCategory subCategory) {
		subCategoryDao.update(subCategory);

	}

	public void delete(Long subCategoryId) {
		subCategoryDao.delete(subCategoryId);

	}

	
	/**
	 * 用商品id找出此商品在哪些SubCategory中
	 * @param itemId
	 * @return
	 */
	public List<SubCategory> findByItemd(Long itemId) {
		return subCategoryDao.findByItemd(itemId);
	}

}
