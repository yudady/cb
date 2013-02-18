package com.charitybuzz.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dao.DualDao;
import com.charitybuzz.dao.ItemDao;
import com.charitybuzz.dto.Item;

public class ItemService {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(ItemService.class);

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

	/**
	 * 最接近結標日的商品列表
	 * 
	 * @param pageInfo
	 * @return
	 */
	public List<Item> findClosingNext(int count) {
		return itemDao.findClosingNext(0, count);
	}

	/**
	 * 差價最大的商品列表
	 * 
	 * @param pageInfo
	 * @return
	 */
	public List<Item> findDeals(int count) {
		return itemDao.findDeals(0, count);
	}

	/**
	 * 最受歡迎的商品列表
	 * 
	 * @param pageInfo
	 * @return
	 */
	public List<Item> findMostPopular(int count) {
		return itemDao.findMostPopular(0, count);
	}

	/**
	 * 新進商品的商品列表
	 * 
	 * @param pageInfo
	 * @return
	 */
	public List<Item> findRecentlyAdded(int count) {
		return itemDao.findRecentlyAdded(0, count);
	}

	/**
	 * 分頁 最接近結標日的商品列表
	 * 
	 * @return
	 */
	public Pager<Item> findPagerByClosingNext() {
		log.debug("findPagerByClosingNext");
		return itemDao.findPagerByClosingNext();
	}

	/**
	 * 分頁 差價最大的商品列表
	 * 
	 * @return
	 */
	public Pager<Item> findPagerByHotDeals() {
		log.debug("findPagerByHotDeals");
		return itemDao.findPagerByHotDeals();
	}

	/**
	 * 分頁 最受歡迎的商品列表
	 * 
	 * @return
	 */
	public Pager<Item> findPagerByPopular() {
		log.debug("findPagerByPopular");
		return itemDao.findPagerByPopular();
	}

	/**
	 * 分頁 新進商品的商品列表
	 * 
	 * @return
	 */
	public Pager<Item> findPagerByRecentAdd() {
		log.debug("findPagerByRecentAdd");
		return itemDao.findPagerByRecentAdd();
	}

}
