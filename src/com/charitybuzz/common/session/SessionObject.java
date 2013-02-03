package com.charitybuzz.common.session;

public class SessionObject {

	private boolean manager;

	private String email;

	public SessionObject(boolean manager, String email) {
		this.manager = manager;
		this.email = email;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
