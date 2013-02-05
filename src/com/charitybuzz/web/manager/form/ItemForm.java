package com.charitybuzz.web.manager.form;

import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 第一級目錄
 * 
 * @author Administrator
 * 
 */
public class ItemForm {

	/**
	 * 第一級目錄id
	 */
	private Long itemIdForm;
	/**
	 * 第一級目錄名稱分類種類
	 */
	private String title;

	/**
	 * 此商品有哪些二級目錄
	 */
	private List<Long> subCategoryIds;

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

	public List<Long> getSubCategoryIds() {
		return subCategoryIds;
	}

	public void setSubCategoryIds(List<Long> subCategoryIds) {
		this.subCategoryIds = subCategoryIds;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}
}
