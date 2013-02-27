package com.charitybuzz.web.manager.form;

import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 
 * @author Administrator
 * 
 */
public class AuctionForm {

	private Long id;
	/**
	 * 主題
	 */
	private String title;
	/**
	 * 描述
	 */
	private String brief;
	/**
	 * 網址
	 */
	private String webSite;
	/**
	 * logo
	 */
	private String auctionLogoPath;
	private String auctionLogoPathAction;

	private CommonsMultipartFile file;

	/**
	 * 拍賣會 開始日期 startDate
	 */
	private Date startDate;
	/**
	 * 拍賣會 結束日期 closeDate
	 */
	private Date closeDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getAuctionLogoPath() {
		return auctionLogoPath;
	}

	public void setAuctionLogoPath(String auctionLogoPath) {
		this.auctionLogoPath = auctionLogoPath;
	}

	public String getAuctionLogoPathAction() {
		return auctionLogoPathAction;
	}

	public void setAuctionLogoPathAction(String auctionLogoPathAction) {
		this.auctionLogoPathAction = auctionLogoPathAction;
	}

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}
}
