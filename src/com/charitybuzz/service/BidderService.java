package com.charitybuzz.service;

import com.charitybuzz.dao.BidderDao;
import com.charitybuzz.domain.Bidder;

public class BidderService {

	private BidderDao bidderDao;

	public void setBidderDao(BidderDao bidderDao) {
		this.bidderDao = bidderDao;
	}

	/**
	 * pk find object
	 * 
	 * @param id
	 * @return
	 */
	public Bidder findById(Long id) {
		return bidderDao.findById(id);
	}

}
