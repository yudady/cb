package com.charitybuzz.cache;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.Constant;
import com.charitybuzz.dto.Auction;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.dto.SlideItem;
import com.charitybuzz.service.AuctionService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;

/**
 * index頁面輪動圖片。最大20個
 * 以拍賣會為基準
 * @author Administrator
 */
public class SlideshowService {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(SlideshowService.class);

	/**
	 * 緩存目錄
	 */
	private List<SlideItem> slideItems;

	/**
	 * 圖片
	 */
	private PictureService pictureService;
	/**
	 * 全部商品
	 */
	private ItemService itemService;
	/**
	 * 拍賣會
	 */
	private AuctionService auctionService;
	
	
	
	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}


	public List<SlideItem> getSlideItems() {
		if (this.slideItems != null) {
			return this.slideItems;
		}
		return this.searchSlideShows(Constant.SEARCH_PICTURES);
	}

	public void setSlideItems(List<SlideItem> slideItems) {
		this.slideItems = slideItems;
	}
	private List<SlideItem> searchSlideShows(int count) {
		log.debug("[LOG][searchSlideShows]");
		List<Item> items = itemService.findSlideShow(Constant.SEARCH_PICTURES);
		
		List<SlideItem> slideItems = new ArrayList<SlideItem>();
		
		for (Item item : items) {
			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
			Auction auction = auctionService.findById(item.getAuctionId());
			slideItems.add(new SlideItem(auction, item));
			
		}
		return slideItems;
	}

	/**
	 * AOP
	 * 
	 * @param jp
	 */
	public void doAfter(JoinPoint jp) {
		log.debug("log Ending method: " + jp.getTarget().getClass().getName()
				+ "." + jp.getSignature().getName());

		this.setSlideItems(null);
	}
}
