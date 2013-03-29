package com.charitybuzz.service;

import com.charitybuzz.dao.WatchingDao;
import com.charitybuzz.dto.Watching;

/**
 * 關注
 * 
 * @author Administrator
 * 
 */
public class WatchingService {

	private WatchingDao watchingDao;

	public void setWatchingDao(WatchingDao watchingDao) {
		this.watchingDao = watchingDao;
	}

	/**
	 * 增加關注
	 * 
	 * @param bidderId
	 * @param itemId
	 */
	public void addBidderWaching(Long bidderId, Long itemId) {
		watchingDao.insert(bidderId, itemId);
	}

	/**
	 * 刪除關注
	 * 
	 * @param bidderId
	 * @param itemId
	 */
	public void delBidderWaching(Long bidderId, Long itemId) {
		watchingDao.deleteByBidderIdItemId(bidderId, itemId);
	}

	/**
	 * 競標者是否關注此商品
	 * 
	 * @param id
	 * @param itemId
	 * @return
	 */
	public Watching isWatch(Long bidderId, Long itemId) {
		return watchingDao.findByBidderIdItemId(bidderId, itemId);
	}

}
