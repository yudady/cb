package com.charitybuzz.common.model;

public class PageInfo {

	/**
	 * 每頁資料數
	 */
	private int pageSize = 10;

	/**
	 * 目前的頁數
	 */
	private int pageNumber = 1;

	/**
	 * 資料總數
	 */
	private int totalCount;

	public PageInfo(int pageSize, int pageNumber) {
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param page
	 *            The page to set.
	 */
	public void setPageNumber(int page) {
		this.pageNumber = page;
	}

	/**
	 * @return Returns the pageSize.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            The pageSize to set.
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return Returns the totalCount.
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount
	 *            The totalCount to set.
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public boolean hasNext() {
		if (this.pageNumber * this.pageSize >= this.totalCount) {
			return false;
		}
		return true;
	}

	public int next() {
		if (hasNext()) {
			return this.pageNumber + 1;
		}
		return this.pageNumber;
	}

	public boolean hasPrevious() {
		if (this.pageNumber <= 1) {
			return false;
		}
		return true;
	}

	public int previous() {
		if (hasPrevious()) {
			return this.pageNumber - 1;
		}
		return this.pageNumber;
	}

	public int getTotalPage() {
		int totalPage = this.totalCount / this.pageSize;
		if (this.totalCount % this.pageSize > 0) {
			totalPage++;
		}
		return totalPage;
	}

	public final int getFirstRowNumber() {
		return getPageSize() * (getPageNumber() - 1);
	}

	public final int getLastRowNumber() {
		return getPageSize() * getPageNumber();
	}
}