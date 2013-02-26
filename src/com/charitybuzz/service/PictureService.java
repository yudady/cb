package com.charitybuzz.service;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.charitybuzz.common.Constant;
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
	 * @param pictures
	 */
	public void insert(List<Picture> pictures) {
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

		for (int i = 0; i < updatePictures.size(); i++) {
			Picture pi = updatePictures.get(i);
			Picture delPicture = pictureDao.findByPK(pi.getId());

			if (StringUtils.isNotBlank(pi.getPhotoPath())) {
				new File(Constant.UPLOAD_FOLDER + delPicture.getPhotoPath())
						.delete();
			} else {
				pi.setPhotoPath(delPicture.getPhotoPath());
			}
			pictureDao.update(pi);

		}

	}

	/**
	 * 把圖片和db清除
	 * 
	 * @param picIds
	 */
	public void delete(List<Long> picIds) {
		for (Long picId : picIds) {
			Picture picture = pictureDao.findByPK(picId);
			new File(Constant.UPLOAD_FOLDER + picture.getPhotoPath()).delete();
			pictureDao.deleteByPK(picId);
		}

	}

	/**
	 * index 輪播圖片
	 * 
	 * @param firstRowNumber
	 * @param lastRowNumber
	 * @return
	 */
	public List<Picture> findPictures(int firstRowNumber, int lastRowNumber) {
		return pictureDao.findPictures(firstRowNumber, lastRowNumber);
	}

}
