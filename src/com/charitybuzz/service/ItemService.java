package com.charitybuzz.service;

import java.util.Date;
import java.util.List;

import com.charitybuzz.dao.DualDao;
import com.charitybuzz.dao.ItemDao;
import com.charitybuzz.dto.Item;

public class ItemService {

	private ItemDao itemDao;

	private DualDao dualDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void setDualDao(DualDao dualDao) {
		this.dualDao = dualDao;
	}

	public List<Item> findBySubCategoryId(Long id) {
		return itemDao.findBySubCategoryId(id);
	}

	/**
	 * 找出categoryId的全部商品
	 * 
	 * @param categoryId
	 * @return
	 */
	public List<Item> findByCategoryId(Long categoryId) {
		return itemDao.findByCategoryId(categoryId);
	}

	/**
	 * pk find object
	 * 
	 * @param itemId
	 * @return
	 */
	public Item findById(Long itemId) {
		return itemDao.findById(itemId);
	}

	/**
	 * 當前時間為結算日
	 * 
	 * @return
	 */
	public List<Item> findEndBiddingByCloseDate() {
		return itemDao.findByCloseDateLessTargetDate(new Date());
	}

	/**
	 * 把商品更新為結標
	 * 
	 * @param id
	 * @return
	 */
	public void updateClosingBidding(Long id) {
		itemDao.updateClosingBidding(id);
	}

	public List<Item> findAll() {
		return itemDao.findAll();
	}

	public Long insert(Item item) {

		Long itemId = dualDao.getNextPk("seq_item.nextval");
		item.setId(itemId);
		itemDao.insert(item);
		return itemId;
	}

	public void update(Item item) {
		itemDao.update(item);
	}

	public void delete(Long itemId) {
		itemDao.delete(itemId);
	}

}
