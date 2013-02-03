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
	 * 用一級目錄id
	 * 找出全部二級目錄的商品
	 * @return
	 */
	public List<SubCategory> findByCategoryId(Long categoryId) {
		return subCategoryDao.findByCategoryId(categoryId);
	}

}
