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
	 * 拍賣商家ID
	 */
	private Long id;
	/**
	 * 公司名稱
	 */
	private String name;
	/**
	 * 密碼
	 */
	private String passWord;

	/**
	 * 公司logo
	 */
	private String logo;
	/**
	 * 簡介
	 */
	private String brief;
	/**
	 * 網址
	 */
	private String webSite;

	public Operator() {
	}

	public Operator(String name, String passWord, String logo,
			String brief, String webSite) {
		this.name = name;
		this.passWord = passWord;
		this.logo = logo;
		this.brief = brief;
		this.webSite = webSite;
	}
	public Operator(Long id, String name, String passWord, String logo,
			String brief, String webSite) {
		this.id = id;
		this.name = name;
		this.passWord = passWord;
		this.logo = logo;
		this.brief = brief;
		this.webSite = webSite;
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}

}
