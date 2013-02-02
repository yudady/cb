package com.charitybuzz.domain;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 商品
 * 
 * @author Administrator
 * 
 */
public class Item {

	private Long id;

	/**
	 * 商品訊息
	 */
	private String title;

	/**
	 * currentBid 當前標價 Current Bid: $2,250
	 */
	private Double currentBid;

	/**
	 * 商品 開始日期 startDate
	 */
	private Date startDate;
	/**
	 * Lot Closes 商品結束日期 closeDate
	 */
	private Date closeDate;

	/**
	 * ESTIMATED_VALUE 估計價值 Estimated Value: $9,500
	 */
	private Double estimatedValue;

	/**
	 * 下次最小標價 Minimum Next Bid: $2,500
	 */
	private Double incrementPrice;

	/**
	 * 0.結標 1.拍賣中
	 */
	private int status;
	/**
	 * LOTDETAILS訊息
	 */
	private String lotDetails;
	/**
	 * LEGALTERMS訊息
	 */
	private String legalTerms;
	/**
	 * SHIPPING訊息
	 */
	private String shipping;

	/**
	 * 當前贏家id winningBidderId
	 */
	private Long winningBidderId;
	/**
	 * 資料建立的時間
	 */
	private Date createdDate;
	/**
	 * 最後修改時間
	 */
	private Date updatedDate;

	// =======關聯資料===以下內容沒有資料庫column==========

	/**
	 * (6 bids Bid次數)bidlog的筆數
	 */
	private int bidTimes;
	/**
	 * 歷史紀錄
	 */
	private List<Bidlog> bidlogs;
	/**
	 * 圖片
	 */
	private List<Picture> pictures;
	/**
	 * 主要圖片路徑
	 */
	private String mainPicturePath;

	/**
	 * 到結標日差多少時間
	 */
	private Long difDay;

	// ====================================================

	public Item() {
	}

	public Item(Long id, String title, Double currentBid, Date startDate,
			Date closeDate, Double estimatedValue, Double incrementPrice,
			int status, String lotDetails, String legalTerms, String shipping,
			Long winningBidderId) {
		this.id = id;
		this.title = title;
		this.currentBid = currentBid;
		this.startDate = startDate;
		this.closeDate = closeDate;
		this.estimatedValue = estimatedValue;
		this.incrementPrice = incrementPrice;
		this.status = status;
		this.lotDetails = lotDetails;
		this.legalTerms = legalTerms;
		this.shipping = shipping;
		this.winningBidderId = winningBidderId;
	}

	// ====================================================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(Double currentBid) {
		this.currentBid = currentBid;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Double getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(Double estimatedValue) {
		this.estimatedValue = estimatedValue;
	}

	public Double getIncrementPrice() {
		return incrementPrice;
	}

	public void setIncrementPrice(Double incrementPrice) {
		this.incrementPrice = incrementPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getLotDetails() {
		return lotDetails;
	}

	public void setLotDetails(String lotDetails) {
		this.lotDetails = lotDetails;
	}

	public String getLegalTerms() {
		return legalTerms;
	}

	public void setLegalTerms(String legalTerms) {
		this.legalTerms = legalTerms;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public Long getWinningBidderId() {
		return winningBidderId;
	}

	public void setWinningBidderId(Long winningBidderId) {
		this.winningBidderId = winningBidderId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getBidTimes() {
		return bidTimes;
	}

	public void setBidTimes(int bidTimes) {
		this.bidTimes = bidTimes;
	}


	public List<Bidlog> getBidlogs() {
		return bidlogs;
	}

	public void setBidlogs(List<Bidlog> bidlogs) {
		this.bidlogs = bidlogs;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		if(pictures.size() > 0){
			this.setMainPicturePath(pictures.get(0).getPhotoPath());
		}
		this.pictures = pictures;
	}

	public String getMainPicturePath() {
		return mainPicturePath;
	}

	public void setMainPicturePath(String mainPicturePath) {
		this.mainPicturePath = mainPicturePath;
	}

	public Long getDifDay() {
		return difDay;
	}

	public void setDifDay(Long difDay) {
		this.difDay = difDay;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}
}
