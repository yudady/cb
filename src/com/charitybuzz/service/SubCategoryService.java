package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dao.SubCategoryDao;
import com.charitybuzz.dto.SubCategory;

/**
 * 二級目錄
 * 
 * @author Administrator
 * 
 */
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

	/**
	 * 找出全部二級目錄
	 * 
	 * @return
	 */
	public List<SubCategory> findAll() {
		return subCategoryDao.findAll();
	}

	/**
	 * 分頁
	 * 
	 * @return
	 */
	public Pager<SubCategory> findPager() {
		return subCategoryDao.findPager();
	}

	/**
	 * insert
	 * 
	 * @param subCategory
	 */
	public void insert(SubCategory subCategory) {
		subCategoryDao.insert(subCategory);

	}

	/**
	 * findById
	 * 
	 * @param subCategoryId
	 * @return
	 */
	public SubCategory findById(Long subCategoryId) {
		return subCategoryDao.findById(subCategoryId);
	}

	/**
	 * update
	 * 
	 * @param subCategory
	 */
	public void update(SubCategory subCategory) {
		subCategoryDao.update(subCategory);

	}

	/**
	 * delete
	 * 
	 * @param subCategoryId
	 */
	public void delete(Long subCategoryId) {
		subCategoryDao.delete(subCategoryId);

	}

	/**
	 * 用商品id找出此商品在哪些SubCategory中
	 * 
	 * @param itemId
	 * @return
	 */
	public List<SubCategory> findByItemd(Long itemId) {
		return subCategoryDao.findByItemd(itemId);
	}

}
