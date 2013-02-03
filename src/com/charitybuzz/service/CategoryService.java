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
	 * 
	 * @return
	 */
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	/**
	 * 用id找object
	 * 
	 * @param categoryId
	 * @return
	 */
	public Category findById(Long categoryId) {
		return categoryDao.findById(categoryId);
	}

	/**
	 * 差入
	 * 
	 * @param category
	 * @return
	 */
	public void insert(Category category) {
		categoryDao.insert(category);
	}

	public void update(Category category) {
		categoryDao.update(category);
	}

	public void delete(Long categoryId) {
		categoryDao.delete(categoryId);
	}

}
