package com.charitybuzz.web.cb;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.cache.SidebarService;
import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Auction;
import com.charitybuzz.dto.Bidlog;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.service.AuctionService;
import com.charitybuzz.service.BidlogService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;

/**
 * 結標商品
 * 
 * @author Administrator
 * 
 */
@Controller
public class DisplayClosedController {
	/** logger. */
	private Logger log = LoggerFactory.getLogger(DisplayClosedController.class);

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
	 * 歷史紀錄
	 */
	@Resource
	private BidlogService bidlogService;

	/**
	 * 拍賣會
	 */
	@Resource
	private AuctionService auctionService;

	/**
	 * displayClosed 查結標商品
	 * @param displayClosed
	 * @param categoryId
	 * @param categoryName
	 * @return
	 */
	@RequestMapping(value = { "/categories/{categoryId}/{categoryName}/index" }, method = RequestMethod.GET, params = "displayClosed=true")
	public ModelAndView categoryDisplayClosed(
			@RequestParam(value = "displayClosed", required = true) boolean displayClosed,
			@PathVariable Long categoryId,
			@PathVariable String categoryName) {
		
		
		log.debug("[LOG][categoryId]" + categoryId);
		log.debug("[LOG][displayClosed]" + displayClosed);
		
		
		
		ModelAndView mav = new ModelAndView("cb/itemsPager");

		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getCategories();
		mav.addObject("categories", categories);

		/**
		 * 分頁結標商品
		 */
		Pager<Item> pager = itemService
				.findPagerCloseItemsByCategoryId(categoryId);
		List<Item> items = pager.getDatas();
		for (Item item : items) {

			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		mav.addObject("pager", pager);
		return mav;
	}

	/**
	 * displayClosed 查結標商品
	 * 
	 * @param subcategoryId
	 * @return
	 */
	@RequestMapping(value = { "/categories/{categoryId}/{categoryName}/subcategories/{subcategoryId}/{subCategoryName}/index" }, method = RequestMethod.GET, params = "displayClosed=true")
	public ModelAndView subCategoryDisplayClosed(
			@RequestParam(value = "displayClosed", required = true) boolean displayClosed,
			@PathVariable Long categoryId, @PathVariable String categoryName,
			@PathVariable Long subcategoryId,
			@PathVariable String subCategoryName) {

		log.debug("[LOG][subcategoryId]" + subcategoryId);
		log.debug("[LOG][displayClosed]" + displayClosed);

		ModelAndView mav = new ModelAndView("cb/itemsPager");
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getCategories();
		mav.addObject("categories", categories);
		/**
		 * 分頁結標商品
		 */
		Pager<Item> pager = itemService
				.findPagerCloseItemsBySubCategoryId(subcategoryId);
		List<Item> items = pager.getDatas();
		for (Item item : items) {

			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		mav.addObject("pager", pager);
		return mav;
	}

	/**
	 * 
	 * @param auctionId
	 * @return
	 */
	// http://localhost:8080/cb/auctions/1/index.do?displayClosed=true
	@RequestMapping(value = "/auctions/{auctionId}/index", method = RequestMethod.GET, params = "displayClosed=true")
	public ModelAndView index(
			@RequestParam(value = "displayClosed", required = true) boolean displayClosed,
			@PathVariable Long auctionId) {

		log.debug("[LOG][auctionId]" + auctionId);
		log.debug("[LOG][displayClosed]" + displayClosed);

		ModelAndView mav = new ModelAndView("cb/itemsPager");

		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getCategories();
		mav.addObject("categories", categories);

		Auction auction = auctionService.findById(auctionId);
		mav.addObject("auction", auction);

		/**
		 * 分頁結標商品
		 */
		Pager<Item> pager = itemService
				.findPagerCloseItemsByAuctionId(auctionId);
		List<Item> items = pager.getDatas();
		for (Item item : items) {
			Long itemId = item.getId();

			List<Bidlog> bidlogs = bidlogService.findByItemId(itemId);
			item.setBidTimes(bidlogs.size());

			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		mav.addObject("pager", pager);
		return mav;
	}

	/**
	 * 
	 * @param displayClosed
	 * @param auctionId
	 * @return
	 */
	// http://localhost:8080/cb/tabs/1/list.do?displayClosed=true
	@RequestMapping(value = "/tabs/{tabIndex}/list", method = RequestMethod.GET, params = "displayClosed=true")
	public ModelAndView tabsList(@PathVariable int tabIndex) {

		log.debug("[LOG][tabIndex]");
		ModelAndView mav = new ModelAndView("cb/itemsPager");
		mav.addObject("tabIndex", tabIndex);

		List<Category> categories = sidebarService.getCategories();
		mav.addObject("categories", categories);
		/**
		 * 全部商品
		 */
		Pager<Item> pager = null;
		switch (tabIndex) {
		case 1:
			pager = itemService.findPagerCloseItemsByClosingNext();
			break;
		case 2:
			pager = itemService.findPagerCloseItemsByHotDeals();
			break;
		case 3:
			pager = itemService.findPagerCloseItemsByPopular();
			break;
		case 4:
			pager = itemService.findPagerCloseItemsByRecentAdd();
			break;
		default:
			break;
		}
		List<Item> items = pager.getDatas();
		mav.addObject("pager", pager);

		for (Item item : items) {

			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		return mav;
	}
}
