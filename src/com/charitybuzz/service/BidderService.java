package com.charitybuzz.service;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dao.BidderDao;
import com.charitybuzz.dto.Bidder;

/**
 * 投標者
 * 
 * @author Administrator
 * 
 */
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

	/**
	 * 用email找投標者
	 * 
	 * @param email
	 * @return
	 */
	public Bidder findByEmail(String email) {
		return bidderDao.findByEmail(email);
	}

	/**
	 * 分頁，投標者
	 * 
	 * @return
	 */
	public Pager<Bidder> findPager() {
		return bidderDao.findPager();
	}

	/**
	 * 差入
	 * 
	 * @param bidder
	 */
	public void insert(Bidder bidder) {
		bidderDao.insert(bidder);
	}

	/**
	 * update
	 * 
	 * @param bidder
	 */
	public void update(Bidder bidder) {
		bidderDao.update(bidder);
	}

	/**
	 * delete
	 * 
	 * @param bidderId
	 */
	public void delete(Long bidderId) {
		bidderDao.delete(bidderId);
	}
}
