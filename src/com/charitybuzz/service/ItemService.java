package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.dao.ItemDao;
import com.charitybuzz.domain.Item;
public class ItemService {

	private ItemDao itemDao;
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public List<Item> findBySubCategoryId(Long id) {
		return itemDao.findBySubCategoryId(id);
	}

	/**
	 * 找出categoryId的全部商品
	 * @param categoryId
	 * @return
	 */
	public List<Item> findByCategoryId(Long categoryId) {
		return itemDao.findByCategoryId(categoryId);
	}

	public Item findById(Long itemId) {
		return itemDao.findById(itemId);
	}

}
