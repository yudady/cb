package com.charitybuzz.web.manager.form;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 第一級目錄
 * 
 * @author Administrator
 * 
 */
public class ItemForm implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1772039844990388765L;

	/**
	 * 此商品有哪些二級目錄
	 */
	private List<Long> subCategoryIds;
	/**
	 * 第一級目錄id
	 */
	private Long itemIdForm;
	/**
	 * 第一級目錄名稱分類種類
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
	private Long auctionId;

	public Long getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(Long auctionId) {
		this.auctionId = auctionId;
	}

	private List<CommonsMultipartFile> files;

	private List<Integer> priorities;

	private List<Long> picIds;

	private List<String> cruds;

	public List<Long> getSubCategoryIds() {
		return subCategoryIds;
	}

	public void setSubCategoryIds(List<Long> subCategoryIds) {
		this.subCategoryIds = subCategoryIds;
	}

	public Long getItemIdForm() {
		return itemIdForm;
	}

	public void setItemIdForm(Long itemIdForm) {
		this.itemIdForm = itemIdForm;
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

	public List<CommonsMultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<CommonsMultipartFile> files) {
		this.files = files;
	}

	public List<Integer> getPriorities() {
		return priorities;
	}

	public void setPriorities(List<Integer> priorities) {
		this.priorities = priorities;
	}

	public List<Long> getPicIds() {
		return picIds;
	}

	public void setPicIds(List<Long> picIds) {
		this.picIds = picIds;
	}

	public List<String> getCruds() {
		return cruds;
	}

	public void setCruds(List<String> cruds) {
		this.cruds = cruds;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}
}
