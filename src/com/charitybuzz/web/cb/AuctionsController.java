package com.charitybuzz.web.cb;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.cache.SidebarService;
import com.charitybuzz.cache.TopItemsCategoryService;
import com.charitybuzz.common.Constant;
import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Auction;
import com.charitybuzz.dto.Bidlog;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.dto.TopItemsCategory;
import com.charitybuzz.service.AuctionService;
import com.charitybuzz.service.BidlogService;
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
	@Resource
	private BidlogService bidlogService;

	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView indexPage() {
		log.debug("[LOG][auctions]");
		ModelAndView mav = new ModelAndView("cb/auctions");
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getCategories();
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
	
	
	/**
	 * 
	 * @param auctionId
	 * @return
	 */
	@RequestMapping(value = "/{auctionId}/index", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable Long auctionId) {
		ModelAndView mav = new ModelAndView("cb/itemsPager");

		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getCategories();
		mav.addObject("categories", categories);

		
		Auction auc = auctionService.findById(auctionId);
		mav.addObject("auc", auc);
		
		
		
		/**
		 * 分頁商品
		 */
		Pager<Item> pager = itemService.findPagerByAuctionId(auctionId);
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
}
