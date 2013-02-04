package com.charitybuzz.web.manager.form;

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
	private Long id;
	/**
	 * 第一級目錄名稱分類種類
	 */
	private String name;

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

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}
}
