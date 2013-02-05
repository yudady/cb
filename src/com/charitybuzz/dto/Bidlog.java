package com.charitybuzz.dto;

import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 商品投標的歷史紀錄
 * 
 * @author Administrator
 * 
 */
public class Bidlog {

	/**
	 * bid歷史紀錄id
	 */
	private Long id;
	/**
	 * 競標者id
	 */
	private Long bidderId;
	/**
	 * 商品id
	 */
	private Long itemId;
	/**
	 * 價格
	 */
	private Double price;
	/**
	 * 競價時間
	 */
	private Date bidTime;

	public Bidlog() {
	}

	public Bidlog(Long bidderId, Long itemId, Double price) {
		this.bidderId = bidderId;
		this.itemId = itemId;
		this.price = price;
	}
	public Bidlog(Long id, Long bidderId, Long itemId, Double price,
			Date bidTime) {
		this.id = id;
		this.bidderId = bidderId;
		this.itemId = itemId;
		this.price = price;
		this.bidTime = bidTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBidderId() {
		return bidderId;
	}

	public void setBidderId(Long bidderId) {
		this.bidderId = bidderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getBidTime() {
		return bidTime;
	}

	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}
}
