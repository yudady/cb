package com.charitybuzz.service;

import java.io.File;
import java.util.List;

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

	/**
	 * 新增圖片
	 * 
	 * @param itemId
	 * @param pictures
	 */
	public void insert(Long itemId, List<Picture> pictures) {
		for (Picture picture : pictures) {
			pictureDao.insert(picture);
		}
	}

	/**
	 * 刪除舊圖片 更新DB資料 新圖片，再controller以處理，路徑再PhotoPath中
	 * 
	 * @param updatePictures
	 */
	public void update(List<Picture> updatePictures) {
		String uploadFolder = WebUtils.getUPLOAD_FOLDER();
		for (int i = 0; i < updatePictures.size(); i++) {
			Picture delPicture = pictureDao.findByPK(updatePictures.get(i)
					.getId());
			new File(uploadFolder + delPicture.getPhotoPath()).delete();
			pictureDao.update(updatePictures.get(i));

		}

	}

	/**
	 * 把圖片和db清除
	 * 
	 * @param picIds
	 */
	public void delete(List<Long> picIds) {
		String uploadFolder = WebUtils.getUPLOAD_FOLDER();
		for (Long picId : picIds) {
			Picture picture = pictureDao.findByPK(picId);
			new File(uploadFolder + picture.getPhotoPath()).delete();
			pictureDao.deleteByPK(picId);
		}

	}

}
