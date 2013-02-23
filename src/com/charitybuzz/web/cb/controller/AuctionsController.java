package com.charitybuzz.web.cb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.operate.SidebarService;
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
	private BidlogService bidlogService;
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView indexPage() {
		ModelAndView mav = new ModelAndView("auctions");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/{auctioneerId}/catalog_items",method = RequestMethod.GET)
	public ModelAndView auctions(@PathVariable Long auctioneerId) {
		log.debug("[LOG][auctioneerId]" + auctioneerId);

		ModelAndView mav = new ModelAndView("itemsPager");
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		/**
		 * 分頁商品
		 */
		Pager<Item> pager = itemService.findPagerByAuctioneerId(auctioneerId);
		List<Item> items = pager.getDatas();
		for (Item item : items) {

			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		mav.addObject("pager", pager);
		return mav;
	}
	

}
