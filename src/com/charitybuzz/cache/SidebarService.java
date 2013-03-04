package com.charitybuzz.cache;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.SubCategory;
import com.charitybuzz.service.CategoryService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.SubCategoryService;

/**
 * @author Administrator
 */
public class SidebarService {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(SidebarService.class);

	/**
	 * 緩存目錄
	 */
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

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public List<Category> getSidebar() {
		if (this.categories != null) {
			return this.categories;
		}
		return this.searchSidebarData();

	}

	private List<Category> searchSidebarData() {
		log.debug("[LOG][searchSidebarData]");
		
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
		return this.categories;
	}
	
	
	/**
	 * AOP
	 * @param jp
	 */
	public void doAfter(JoinPoint jp) {
		log.debug("log Ending method: " + jp.getTarget().getClass().getName()
				+ "." + jp.getSignature().getName());
		
		this.setCategories(null);
	}
	
	
}
