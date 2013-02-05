package com.charitybuzz.web.manager.form;

/**
 * 第二級目錄
 * 
 * @author Administrator
 * 
 */
public class SubCategoryForm {

	/**
	 * 第二級目錄id
	 */
	private Long subCaId;
	/**
	 * 第一級目錄id
	 */
	private Long categoryId;
	/**
	 * 第二級目錄名稱
	 */
	private String name;
	/**
	 * 第二級目錄描述
	 */
	private String descript;

	public Long getSubCaId() {
		return subCaId;
	}

	public void setSubCaId(Long subCaId) {
		this.subCaId = subCaId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

}
