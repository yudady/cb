package com.charitybuzz.dto;

import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Picture {

	/**
	 * 圖片id，自動編號
	 */
	private Long id;
	/**
	 * 商品id
	 */
	private Long itemId;
	/**
	 * 圖片顯示的優先權
	 * 
	 * <pre>
	 * 數字越小越優先，預設值等於自動編號的值
	 * </pre>
	 */
	private int priority;
	/**
	 * 圖片路徑
	 */
	private String photoPath;

	/**
	 * 建立時間
	 */
	private Date createdDate;

	// ================================

	public Picture() {
	}

	public Picture(Long itemId, int priority, String photoPath) {
		this.itemId = itemId;
		this.priority = priority;
		this.photoPath = photoPath;
	}
	public Picture(Long id, Long itemId, int priority, String photoPath) {
		this.id = id;
		this.itemId = itemId;
		this.priority = priority;
		this.photoPath = photoPath;
	}
	public Picture(Long id, Long itemId, int priority, String photoPath,
			Date createdDate) {
		this.id = id;
		this.itemId = itemId;
		this.priority = priority;
		this.photoPath = photoPath;
		this.createdDate = createdDate;
	}

	// ================================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}
}
