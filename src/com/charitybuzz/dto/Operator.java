package com.charitybuzz.dto;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 後檯登入者資訊
 * 
 * @author Administrator
 * 
 */
public class Operator {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 名稱
	 */
	private String name;
	/**
	 * 密碼
	 */
	private String passWord;

	public Operator() {
	}

	public Operator(Long id, String name, String passWord) {
		this.id = id;
		this.name = name;
		this.passWord = passWord;
	}

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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}

}
