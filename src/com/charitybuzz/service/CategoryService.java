package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.dao.CategoryDao;
import com.charitybuzz.domain.Category;

public class CategoryService {

	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/**
	 * 找出全部一級目錄
	 * @return
	 */
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

}
