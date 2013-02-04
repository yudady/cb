package com.charitybuzz.service;

import com.charitybuzz.dao.WatchingDao;
import com.charitybuzz.dto.Watching;

public class WatchingService {

	private WatchingDao watchingDao;

	public void setWatchingDao(WatchingDao watchingDao) {
		this.watchingDao = watchingDao;
	}

	public void addBidderWaching(Long bidderId, Long itemId) {
		 watchingDao.insert(bidderId,itemId);
	}

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
	public boolean isWatch(Long bidderId, Long itemId) {
		Watching ws = watchingDao.findByBidderIdItemId(bidderId, itemId);
		if (ws != null) {
			return true;
		}
		return false;
	}

}
