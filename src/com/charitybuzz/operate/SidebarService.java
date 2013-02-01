package com.charitybuzz.operate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.dao.ItemDao;
import com.charitybuzz.domain.Category;
import com.charitybuzz.domain.Item;
import com.charitybuzz.domain.SubCategory;
import com.charitybuzz.service.CategoryService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.SubCategoryService;

public class SidebarService {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(this.getClass());

	private ItemDao itemDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	/**
	 * 第一級目錄
	 */
	private CategoryService categoryService;
	/**
	 * 第二級目錄
	 */
	private SubCategoryService subCategoryService;
	/**
	 * 全部商品
	 */
	private ItemService itemService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setSubCategoryService(SubCategoryService subCategoryService) {
		this.subCategoryService = subCategoryService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

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
			for (int j = 0; j < subCategories.size(); j++) {
				SubCategory subs = subCategories.get(j);
				List<Item> subsItems = itemService.findBySubCategoryId(subs
						.getId());
				subs.setItems(subsItems);
			}
			category.setSubCategories(subCategories);

		}

		List<Item> items = itemDao.findAll();
		log.debug("[LOG]" + items.size());
		for (Item it : items) {
			log.debug("[LOG]" + it);
		}

		return categories;
	}

}
