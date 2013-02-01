package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.dao.CategoryDao;
import com.charitybuzz.domain.Category;

public class CategoryService {

	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

}
