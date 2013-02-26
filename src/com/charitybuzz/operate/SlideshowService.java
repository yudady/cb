package com.charitybuzz.operate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		return pictures;
	}


	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public List<Picture> searchPictures(int count) {
		if(this.pictures == null){
			this.setPictures(pictureService.findPictures(0,count));
		}
		return this.getPictures();
	}

}
