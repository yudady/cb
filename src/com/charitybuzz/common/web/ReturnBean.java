package com.charitybuzz.common.web;
/**
 * ajax return bean
 * @author Administrator
 *
 */
public class ReturnBean {

	private boolean success;
	private String msg;

	public ReturnBean(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
