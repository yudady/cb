package com.charitybuzz.cache;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.Constant;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.TopItemsCategory;
import com.charitybuzz.service.CategoryService;
import com.charitybuzz.service.ItemService;

/**
 * @author Administrator
 */
public class TopItemsCategoryService {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(TopItemsCategoryService.class);

	/**
	 * 緩存目錄
	 */
	private List<TopItemsCategory> topItemsCategorys;
	
	
	/**
	 * 第一級目錄
	 */
	private CategoryService categoryService;
	private ItemService itemService;

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public List<TopItemsCategory> getTopItemsCategorys() {

		if (this.topItemsCategorys != null) {
			return this.topItemsCategorys;
		}
		return this.searchTopItemsCategorys(Constant.CATEGORY_SIZE,Constant.ITEM_SIZE);

	}

	public void setTopItemsCategorys(List<TopItemsCategory> topItemsCategorys) {
		this.topItemsCategorys = topItemsCategorys;
	}

	private List<TopItemsCategory> searchTopItemsCategorys(int categorySize, int itemSize) {
		log.debug("[LOG][searchTopItemsCategorys]");
		
		List<TopItemsCategory> topItems = new ArrayList<TopItemsCategory>();
		
		List<Category> categories = categoryService.findAll();
		
		categorySize = (categorySize > categories.size() ) ? categories.size() : categorySize ;
		
		for(int i = 0 ; i < categorySize ; i ++){
			TopItemsCategory topItem = new TopItemsCategory();
			topItems.add(topItem);
			Category category = categories.get(i);
			topItem.setCategory(category);
			List<Item> items = itemService.findByCategoryId(category.getId());
			topItem.setItems(items);
			
		}
		log.debug("[LOG][categorySize]" + categorySize);
		
		//this.setTopItemsCategorys(topItems);
		return topItems;
	}
}
