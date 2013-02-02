package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.dao.BidlogDao;
import com.charitybuzz.domain.Bidlog;

public class BidlogService {

	private BidlogDao bidlogDao;

	public void setBidlogDao(BidlogDao bidlogDao) {
		this.bidlogDao = bidlogDao;
	}

	/**
	 * 用商品id，找出商品投標的歷史紀錄
	 * 
	 * @param itemId
	 * @return
	 */
	public List<Bidlog> findByItemId(Long itemId) {
		return bidlogDao.findBidlogByitemId(itemId);
	}

}
