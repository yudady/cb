package com.charitybuzz.service;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.charitybuzz.common.util.WebUtils;
import com.charitybuzz.dao.PictureDao;
import com.charitybuzz.dto.Picture;

public class PictureService {

	private PictureDao pictureDao;

	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}

	/**
	 * 用商品id，找出商品的圖片
	 * 
	 * @param itemId
	 * @return
	 */
	public List<Picture> findByItemId(Long itemId) {
		return pictureDao.findPictureByitemId(itemId);
	}

	public void insert(Long itemId, List<Picture> pictures) {
		for (Picture picture : pictures) {
			pictureDao.insert(picture);
		}
	}
	public void update(List<Picture> updatePictures) {
		String uploadFolder = WebUtils.getUPLOAD_FOLDER();
		for(int i = 0 ; i < updatePictures.size() ; i ++){
			Picture delPicture = pictureDao.findByPK(updatePictures.get(i).getId());
			FileUtils.deleteQuietly(new File(uploadFolder
					+ delPicture.getPhotoPath()));
			pictureDao.update(updatePictures.get(i));
			
		}
		

	}
	public void delete(List<Long> picIds) {
		String uploadFolder = WebUtils.getUPLOAD_FOLDER();
		for (Long picId : picIds) {
			Picture picture = pictureDao.findByPK(picId);
			FileUtils.deleteQuietly(new File(uploadFolder
					+ picture.getPhotoPath()));
			pictureDao.deleteByPK(picId);
		}

	}



}
