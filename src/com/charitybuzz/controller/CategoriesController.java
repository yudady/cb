package com.charitybuzz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.domain.Bidlog;
import com.charitybuzz.domain.Category;
import com.charitybuzz.domain.Item;
import com.charitybuzz.domain.Picture;
import com.charitybuzz.operate.SidebarService;
import com.charitybuzz.service.BidlogService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
	/** logger. */
	private Logger log = LoggerFactory.getLogger(CategoriesController.class);

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

	/**
	 * categories/2
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/index", method = RequestMethod.GET)
	public ModelAndView category(@PathVariable Long id) {

		ModelAndView mav = new ModelAndView("items");
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		/**
		 * 全部商品
		 */
		List<Item> items = itemService.findByCategoryId(id);
		mav.addObject("items", items);
		for (Item item : items) {

			Long itemId = item.getId();
			
			
			
			//bidTimes
			
			List<Bidlog> bidlogs = bidlogService.findByItemId(itemId);
			item.setBidTimes(bidlogs.size());
			
			
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}

		return mav;
	}

	@RequestMapping(value = "/{id}/subcategories/{subcategoryId}/index", method = RequestMethod.GET)
	public ModelAndView subCategory(@PathVariable Long subcategoryId) {

		log.debug("[LOG][subcategoryId]" + subcategoryId);

		ModelAndView mav = new ModelAndView("items");
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		/**
		 * 全部商品
		 */
		List<Item> items = itemService.findBySubCategoryId(subcategoryId);
		mav.addObject("items", items);
		for (Item item : items) {

			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}

		return mav;
	}

}
