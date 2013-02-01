package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.dao.PictureDao;
import com.charitybuzz.domain.Picture;

public class PictureService {

	private PictureDao pictureDao;

	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}

	/**
	 * 找出全部一級目錄
	 * 
	 * @return
	 */
	public List<Picture> findAll() {
		return pictureDao.findAll();
	}

}
