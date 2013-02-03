package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.dao.PictureDao;
import com.charitybuzz.dto.Picture;

public class PictureService {

	private PictureDao pictureDao;

	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}

	
	/**
	 * 用商品id，找出商品的圖片
	 * @param itemId
	 * @return
	 */
	public List<Picture> findByItemId(Long itemId) {
		return pictureDao.findPictureByitemId(itemId);
	}


}
