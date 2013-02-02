package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.dao.PictureDao;
import com.charitybuzz.domain.Picture;

public class PictureService {

	private PictureDao pictureDao;

	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}

	public List<Picture> findPictureByitemId(Long itemId) {
		return pictureDao.findPictureByitemId(itemId);
	}


}
