package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dao.AuctionDao;
import com.charitybuzz.dto.Auction;

public class AuctionService {

	private AuctionDao auctionDao;

	public void setAuctionDao(AuctionDao auctionDao) {
		this.auctionDao = auctionDao;
	}

	public Auction findById(Long id) {
		return auctionDao.findById(id);
	}

	/**
	 * 全部
	 * 
	 * @return
	 */
	public List<Auction> findAll() {
		return auctionDao.findAll();
	}

	/**
	 * 分頁
	 * 
	 * @return
	 */
	public Pager<Auction> findPager() {
		return auctionDao.findPager();
	}

	/**
	 * 已經開始的拍賣會
	 * 
	 * @return
	 */
	public List<Auction> findStartAuctions() {
		return auctionDao.findStartAuctions();
	}

	/**
	 * 分頁，拍賣會
	 * 
	 * @return
	 */
	public Pager<Auction> findPagerStartAuctions() {
		return auctionDao.findPagerStartAuctions();
	}

	/**
	 * 尚未開始的拍賣會
	 * 
	 * @return
	 */
	public List<Auction> findWillAuctions() {
		return auctionDao.findWillAuctions();
	}

	/**
	 * insert
	 * 
	 * @param auction
	 */
	public void insert(Auction auction) {
		auctionDao.insert(auction);
	}

	/**
	 * update
	 * 
	 * @param auction
	 */
	public void update(Auction auction) {
		auctionDao.update(auction);
	}

	/**
	 * delete
	 * 
	 * @param auctionId
	 */
	public void delete(Long auctionId) {
		auctionDao.delete(auctionId);

	}

}
