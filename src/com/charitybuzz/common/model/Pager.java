package com.charitybuzz.common.model;

import java.util.List;

import com.charitybuzz.common.context.PagerContext;

public class Pager<E> {
	/**
	 * 第幾頁
	 */
	private int pageIndex;
	/**
	 * 每頁顯示多少條
	 */
	private int pageSize;
	/**
	 * 總共多少條記錄
	 */
	private int totalRecord;
	/**
	 * 放置具體數據的列表
	 */
	private List<E> datas;
	
	
	public Pager() {
		this.setPageSize(PagerContext.getPageSize());
	}
	
	
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public List<E> getDatas() {
		return datas;
	}
	public void setDatas(List<E> datas) {
		this.datas = datas;
	}
}
