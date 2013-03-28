package com.charitybuzz.web.cb;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.cache.SidebarService;
import com.charitybuzz.dto.Auction;
import com.charitybuzz.dto.Bidder;
import com.charitybuzz.dto.Bidlog;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.dto.Watching;
import com.charitybuzz.service.AuctionService;
import com.charitybuzz.service.BidderService;
import com.charitybuzz.service.BidlogService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;
import com.charitybuzz.service.WatchingService;

@Controller
public class ItemController {
	/** logger. */
	private Logger log = LoggerFactory.getLogger(ItemController.class);

	@Resource
	private SidebarService sidebarService;

	/**
	 * 全部商品
	 */
	@Resource
	private ItemService itemService;
	/**
	 * 關注
	 */
	@Resource
	private WatchingService watchingService;
	/**
	 * 商品log
	 */
	@Resource
	private BidlogService bidlogService;
	/**
	 * 商品圖片
	 */
	@Resource
	private PictureService pictureService;
	/**
	 * 投標者
	 */
	@Resource
	private BidderService bidderService;
	
	/**
	 * 拍賣會
	 */
	@Resource
	private AuctionService auctionService;

	/**
	 * tabs4 click url
	 * 
	 * @param itemId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/item/{itemId}/index", method = RequestMethod.GET)
	public ModelAndView item(@PathVariable Long itemId, HttpSession session) {

		return getItem(itemId, session);
	}

	/**
	 * 拍賣會click url
	 * 
	 * @param auctionId
	 * @param auctionTitle
	 * @param itemId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/auctions/{auctionId}/{auctionTitle}/item/{itemId}/index", method = RequestMethod.GET)
	public ModelAndView auctions(@PathVariable Long auctionId,
			@PathVariable String auctionTitle, @PathVariable Long itemId,
			HttpSession session) {

		return getItem(itemId, session);
	}

	/**
	 * 一級目錄，click url
	 * 
	 * @param categoryId
	 * @param categoryName
	 * @param itemId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/categories/{categoryId}/{categoryName}/item/{itemId}/index", method = RequestMethod.GET)
	public ModelAndView categories(@PathVariable Long categoryId,
			@PathVariable String categoryName, @PathVariable Long itemId,
			HttpSession session) {

		return getItem(itemId, session);
	}

	/**
	 * 二級目錄，click url
	 * 
	 * @param categoryId
	 * @param categoryName
	 * @param subcategoryId
	 * @param subCategoryName
	 * @param itemId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/categories/{categoryId}/{categoryName}/subcategories/{subcategoryId}/{subCategoryName}/item/{itemId}/index", method = RequestMethod.GET)
	public ModelAndView subcategories(@PathVariable Long categoryId,
			@PathVariable String categoryName,
			@PathVariable Long subcategoryId,
			@PathVariable String subCategoryName, @PathVariable Long itemId,
			HttpSession session) {

		return getItem(itemId, session);
	}

	private ModelAndView getItem(Long itemId, HttpSession session) {
		ModelAndView mav = new ModelAndView("item");
		List<Category> categories = sidebarService.getCategories();
		mav.addObject("categories", categories);

		log.debug("[itemId]=" + itemId);
		Item item = itemService.findById(itemId);



		mav.setViewName("item");
		if (item == null) {
			log.warn("商品不存在");
			return mav;
		}
		mav.addObject("item", item);
		
		
		Auction auction = auctionService.findById(item.getAuctionId());
		mav.addObject("auction", auction);
		
		
		
		List<Bidlog> bidlogs = bidlogService.findByItemId(itemId);
		item.setBidlogs(bidlogs);
		
		Bidder winner = bidderService.findById(item.getWinningBidderId());
		mav.addObject("winner", winner);

		//
		if (session.getAttribute("bidder") != null) {
			Bidder bidder = (Bidder) session.getAttribute("bidder");
			Watching watching = watchingService.isWatch(bidder.getId(), itemId);
			if (watching != null) {
				item.setWatch(true);
			}
		}

		List<Picture> pictures = pictureService.findByItemId(itemId);
		if (pictures == null) {
			log.warn("多張圖片不存在");
			return mav;
		}
		item.setPictures(pictures);
		return mav;
	}
}
