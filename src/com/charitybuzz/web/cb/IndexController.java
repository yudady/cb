package com.charitybuzz.web.cb;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.cache.SidebarService;
import com.charitybuzz.cache.SlideshowService;
import com.charitybuzz.common.Constant;
import com.charitybuzz.dto.Auction;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.dto.SlideItem;
import com.charitybuzz.service.AuctionService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
	@Resource
	private SidebarService sidebarService;
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
	/**
	 * 拍賣會
	 */
	@Resource
	private AuctionService auctionService;

	@Resource
	private SlideshowService slideshowService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("cb/index");

		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getCategories();
		mav.addObject("categories", categories);


		/**
		 * Current Auctions
		 */
		List<Auction> auctions = auctionService.findStartAuctions();
		mav.addObject("auctions", auctions);
		mav.addObject("auctionsPageSize", Constant.AUCTIONS_PAGESIZE);

		/**
		 * tabs 4
		 */
		List<Item> items = itemService
				.findByHotDeals(Constant.INDEX_TABS_ITEMS_SIZE);
		for (Item item : items) {
			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		mav.addObject("items", items);

		
		/**
		 * top輪動圖片(20個商品)
		 */
		List<SlideItem> slideItems = slideshowService.getSlideItems();
		mav.addObject("slideItems", slideItems);
		
		
		
		return mav;

	}

}
