package com.charitybuzz.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.charitybuzz.domain.Category;
import com.charitybuzz.domain.Item;
import com.charitybuzz.domain.SubCategory;

@Service
public class SidebarService {
	
	
	/** logger. */
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 第一級目錄
	 */
	@Resource
	private CategoryService categoryService;
	/**
	 * 第二級目錄
	 */
	@Resource
	private SubCategoryService subCategoryService;
	/**
	 * 全部商品
	 */
	@Resource
	private ItemService itemService;
	
	
	public List<Category> getSidebar() {

		List<Category> categories = categoryService.findAll();

		for (int i = 0; i < categories.size(); i++) {
			Category category = categories.get(i);
			Long categoryId = category.getId();
			/**
			 * 第二級目錄
			 */
			List<SubCategory> subCategories = subCategoryService
					.findItensByCategoryId(categoryId);
			for(int j = 0 ; j < subCategories.size() ; j ++){
				SubCategory subs = subCategories.get(j);
				List<Item> subsItems = itemService.findBySubCategoryId(subs.getId());
				subs.setItems(subsItems);
			}
			category.setSubCategories(subCategories);

		}
		return categories;
	}

}
