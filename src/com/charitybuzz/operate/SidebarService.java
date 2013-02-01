package com.charitybuzz.operate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.domain.Category;
import com.charitybuzz.domain.Item;
import com.charitybuzz.domain.SubCategory;
import com.charitybuzz.service.CategoryService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.SubCategoryService;

/**
 * 如果商品或目錄有變動，需要把change改為true
 * 
 * @author Administrator
 * 
 */
public class SidebarService {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 目錄是否有改變 true 有變 false沒變
	 */
	private boolean categoeySubCategoryItemChange;


	private List<Category> categories;

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

	public List<Category> getCategories() {
		return categories;
	}


	public boolean isCategoeySubCategoryItemChange() {
		return categoeySubCategoryItemChange;
	}

	public void setCategoeySubCategoryItemChange(
			boolean categoeySubCategoryItemChange) {
		this.categoeySubCategoryItemChange = categoeySubCategoryItemChange;
	}

	public List<Category> getSidebar() {

		if (!isCategoeySubCategoryItemChange()) {
			return categories;
		}
		log.info("[LOG]categoeySubCategoryItemChange="
				+ categoeySubCategoryItemChange);
		
		
		List<Category> cas = categoryService.findAll();

		for (int i = 0; i < cas.size(); i++) {
			Category category = cas.get(i);
			Long categoryId = category.getId();

			List<Item> items = itemService.findByCategoryId(categoryId);
			category.setSubCategoriesItemsCount(items.size());

			List<SubCategory> subCategories = subCategoryService
					.findByCategoryId(categoryId);
			/**
			 * 第二級目錄
			 */
			for (int j = 0; j < subCategories.size(); j++) {
				SubCategory subs = subCategories.get(j);
				List<Item> subsItems = itemService.findBySubCategoryId(subs
						.getId());
				subs.setItems(subsItems);
			}
			category.setSubCategories(subCategories);

		}
		/**
		 * 更新完畢
		 */
		this.categories = cas;
		this.setCategoeySubCategoryItemChange(false);
		return this.categories;
	}
}
