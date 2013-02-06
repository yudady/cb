package com.charitybuzz.dto;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 商品投標的歷史紀錄
 * 
 * @author Administrator
 * 
 */
public class SubcategoryItem {

	private Long id;
	private Long itemId;
	private Long subCategoryId;

	public SubcategoryItem() {
	}

	public SubcategoryItem(Long id, Long itemId, Long subCategoryId) {
		this.id = id;
		this.itemId = itemId;
		this.subCategoryId = subCategoryId;
	}

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

	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}
}
