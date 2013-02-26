package com.charitybuzz.service;

import java.util.List;

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

	public List<Auction> findAll() {
		return auctionDao.findAll();
	}

	public void insert(Auction auction) {
		auctionDao.insert(auction);
	}

	public void update(Auction auction) {
		auctionDao.update(auction);
	}

	public void delete(Long auctionId) {
		auctionDao.delete(auctionId);
		
	}

}
