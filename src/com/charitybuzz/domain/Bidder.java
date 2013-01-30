package com.charitybuzz.domain;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 投標者
 * 
 * @author Administrator
 * 
 */
public class Bidder {

	private Long id;
	private String firstName;
	private String lastName;
	/**
	 * 競標時顯示的名稱
	 */
	private String screenName;
	private String passWord;
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}

}
