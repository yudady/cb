package com.charitybuzz.domain;

import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 第一級目錄
 * 
 * @author Administrator
 * 
 */
public class Category {

	/**
	 * 第一級目錄id
	 */
	private Long id;
	/**
	 * 第一級目錄名稱分類種類
	 */
	private String name;

	// =======關聯資料===以下內容沒有資料庫column==========
	/**
	 * 第二級目錄
	 */
	private List<SubCategory> subCategories;

	/**
	 * 第二級目錄底下有幾個商品數量
	 */
	private int subCategoriesItemsCount;

	//==========================
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	public int getSubCategoriesItemsCount() {
		return subCategoriesItemsCount;
	}

	public void setSubCategoriesItemsCount(int subCategoriesItemsCount) {
		this.subCategoriesItemsCount = subCategoriesItemsCount;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}
}
