package com.charitybuzz.domain;


/**
 * 關注
 * 
 * @author Administrator
 * 
 */
public class Watching {

	private Long id;

	private Long bidderId;

	private Long itemId;
	
	//===========================
	//是否結標
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBidderId() {
		return bidderId;
	}

	public void setBidderId(Long bidderId) {
		this.bidderId = bidderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

}
