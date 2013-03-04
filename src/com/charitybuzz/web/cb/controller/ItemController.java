package com.charitybuzz.web.cb.controller;

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
import com.charitybuzz.dto.Bidder;
import com.charitybuzz.dto.Bidlog;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.dto.Watching;
import com.charitybuzz.service.BidlogService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;
import com.charitybuzz.service.WatchingService;

@Controller
@RequestMapping("/item")
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

	@RequestMapping(value = "/{itemId}/index", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable Long itemId, HttpSession session) {
		ModelAndView mav = new ModelAndView("item");
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);

		log.debug("[itemId]=" + itemId);
		Item item = itemService.findById(itemId);

		mav.setViewName("item");
		if (item == null) {
			log.warn("商品不存在");
			return mav;
		}
		mav.addObject("item", item);
		List<Bidlog> bidlogs = bidlogService.findByItemId(itemId);
		item.setBidlogs(bidlogs);

		//
		if (session.getAttribute("bidder") != null) {
			Bidder bidder = (Bidder) session.getAttribute("bidder");
			Watching watching = watchingService.isWatch(bidder.getId(), itemId);
			if(watching != null){
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
