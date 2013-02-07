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

import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.operate.SidebarService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;

@Controller
@RequestMapping("/items")
public class ItemsListController {
	/** logger. */
	private Logger log = LoggerFactory.getLogger(ItemsListController.class);

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

	@RequestMapping(value = "/{tabIndex}/index", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable int tabIndex) {
		ModelAndView mav = new ModelAndView("items");
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		/**
		 * 全部商品
		 */
		List<Item> items = itemService.findBySubCategoryId(1L);
		mav.addObject("items", items);
		for (Item item : items) {

			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		return mav;
	}

}
