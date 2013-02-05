package com.charitybuzz.web.cb.form;

public class BidForm {

	private Long itemId;
	private Double biddingBidNowPrice;
	private String biddingBidUrl;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Double getBiddingBidNowPrice() {
		return biddingBidNowPrice;
	}

	public void setBiddingBidNowPrice(Double biddingBidNowPrice) {
		this.biddingBidNowPrice = biddingBidNowPrice;
	}

	public String getBiddingBidUrl() {
		return biddingBidUrl;
	}

	public void setBiddingBidUrl(String biddingBidUrl) {
		this.biddingBidUrl = biddingBidUrl;
	}

}
