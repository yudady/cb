package com.charitybuzz.operate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.Constant;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.service.PictureService;

/**
 * @author Administrator
 */
public class SlideshowService {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(SlideshowService.class);

	/**
	 * 緩存目錄
	 */
	private List<Picture> pictures;

	/**
	 * 圖片
	 */
	private PictureService pictureService;

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public List<Picture> getPictures() {
		if (this.pictures != null) {
			return this.pictures;
		}
		return this.searchPictures(Constant.SEARCH_PICTURES);
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	private List<Picture> searchPictures(int count) {
		log.debug("[LOG][searchPictures]");
		List<Picture> pics = pictureService.findPictures(0, count);
		this.setPictures(pics);
		return pics;
	}

}
