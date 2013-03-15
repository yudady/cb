package com.charitybuzz.dto;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Administrator
 * 
 */
public class SlideItem {

	private Auction auction;
	private Item item;

	/**
	 * auction描述
	 */
	private String auctionTitle;
	public String getAuctionTitle() {
		return auction.getTitle();
	}
	/**
	 * itemId
	 */
	private Long itemId;
	/**
	 * item 商品訊息
	 */
	private String itemTitle;
	
	public String getItemTitle() {
		return item.getTitle();
	}
	/**
	 * item 主要圖片路徑
	 */
	private String mainPicturePath;


	public SlideItem(Auction auction, Item item) {
		this.auction = auction;
		this.item = item;
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getItemId() {
		return item.getId();
	}

	public String getMainPicturePath() {
		return item.getMainPicturePath();
	}
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}
}
