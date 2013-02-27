package com.charitybuzz.web.cb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.Constant;
import com.charitybuzz.dto.Auction;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.dto.TopItemsCategory;
import com.charitybuzz.operate.SidebarService;
import com.charitybuzz.operate.TopItemsCategoryService;
import com.charitybuzz.service.AuctionService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;

@Controller
@RequestMapping("/auctions")
public class AuctionsController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(AuctionsController.class);
	/**
	 * 目錄
	 */
	@Resource
	private SidebarService sidebarService;
	/**
	 * 拍賣會
	 */
	@Resource
	private AuctionService auctionService;

	/**
	 * 全部商品
	 */
	@Resource
	private ItemService itemService;
	/**
	 * 商品圖片
	 */
	@Resource
	private PictureService pictureService;
	@Resource
	private TopItemsCategoryService topItemsCategoryService;

	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView indexPage() {
		ModelAndView mav = new ModelAndView("auctions");
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		
		/**
		 * 已經開始的拍賣會
		 */
		List<Auction> auctions = auctionService.findStartAuctions();
		mav.addObject("auctions", auctions);
		/**
		 * 尚未開始的拍賣會
		 */
		List<Auction> willAuctions = auctionService.findWillAuctions();
		mav.addObject("willAuctions", willAuctions);
		/**
		 * tabs
		 */
		List<Item> items = itemService.findByHotDeals(Constant.INDEX_TABS_ITEMS_SIZE);
		for (Item item : items) {
			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		mav.addObject("items", items);
		/**
		 * TopItemsByCategory 
		 */
		List<TopItemsCategory> topItemsCategories = topItemsCategoryService.getTopItemsCategorys();
		mav.addObject("topItemsCategories", topItemsCategories);
		return mav;
	}

}
