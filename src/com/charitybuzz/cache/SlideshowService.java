package com.charitybuzz.cache;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.Constant;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;

/**
 * index頁面輪動圖片。最大20個
 * @author Administrator
 */
public class SlideshowService {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(SlideshowService.class);

	/**
	 * 緩存目錄
	 */
	private List<Item> slideShows;

	/**
	 * 圖片
	 */
	private PictureService pictureService;
	/**
	 * 全部商品
	 */
	private ItemService itemService;

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public List<Item> getSlideShows() {
		if (this.slideShows != null) {
			return this.slideShows;
		}
		return this.searchSlideShows(Constant.SEARCH_PICTURES);
	}

	public void setSlideShows(List<Item> slideShows) {
		this.slideShows = slideShows;
	}

	private List<Item> searchSlideShows(int count) {
		log.debug("[LOG][searchSlideShows]");
		List<Item> items = itemService.findSlideShow(Constant.SEARCH_PICTURES);
		for (Item item : items) {
			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		return items;
	}

	/**
	 * AOP
	 * 
	 * @param jp
	 */
	public void doAfter(JoinPoint jp) {
		log.debug("log Ending method: " + jp.getTarget().getClass().getName()
				+ "." + jp.getSignature().getName());

		this.setSlideShows(null);
	}
}
