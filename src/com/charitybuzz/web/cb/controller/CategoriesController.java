package com.charitybuzz.web.cb.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.cache.SidebarService;
import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Bidlog;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
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
		ModelAndView mav = new ModelAndView("itemsPager");

		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);

		/**
		 * 分頁商品
		 */
		Pager<Item> pager = itemService.findPagerByCategoryId(id);
		List<Item> items = pager.getDatas();
		for (Item item : items) {
			Long itemId = item.getId();

			// bidTimes

			List<Bidlog> bidlogs = bidlogService.findByItemId(itemId);
			item.setBidTimes(bidlogs.size());

			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		mav.addObject("pager", pager);
		return mav;
	}

	@RequestMapping(value = "/{id}/subcategories/{subcategoryId}/index", method = RequestMethod.GET)
	public ModelAndView subCategory(@PathVariable Long subcategoryId) {

		log.debug("[LOG][subcategoryId]" + subcategoryId);

		ModelAndView mav = new ModelAndView("itemsPager");
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		/**
		 * 分頁商品
		 */
		Pager<Item> pager = itemService.findPagerBySubCategoryId(subcategoryId);
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
	 * displayClosed
	 * 
	 * @param subcategoryId
	 * @return
	 */
	// http://localhost:8080/cb/categories/1/subcategories/2/displayClosed.do?closed=1
	@RequestMapping(value = "/{id}/subcategories/{subcategoryId}/index", method = RequestMethod.GET, params = "displayClosed=true")
	public ModelAndView subCategoryDisplayClosed(Long subcategoryId, HttpServletRequest request) {
		//TODO
		
		//查商品關閉
		
		
		log.debug("[LOG][subcategoryId]" + subcategoryId);
		String closed = request.getParameter("closed");
		log.debug("[LOG][closed]" + closed);

		ModelAndView mav = new ModelAndView("itemsPager");
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		/**
		 * 分頁商品
		 */
		Pager<Item> pager = itemService.findPagerBySubCategoryId(subcategoryId);
		List<Item> items = pager.getDatas();
		for (Item item : items) {

			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		mav.addObject("pager", pager);
		return mav;
	}

	@RequestMapping(value = "/viewall", method = RequestMethod.GET)
	public ModelAndView viewAll() {

		ModelAndView mav = new ModelAndView("itemsPager");
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		/**
		 * 分頁商品
		 */
		Pager<Item> pager = itemService.findPager();
		List<Item> items = pager.getDatas();
		for (Item item : items) {

			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		mav.addObject("pager", pager);
		return mav;
	}

	@RequestMapping(value = "/searchItems", method = RequestMethod.POST)
	public ModelAndView searchItems(HttpServletRequest request) {

		log.debug("[LOG][searchItems]");
		String keyWord = request.getParameter("search");
		ModelAndView mav = new ModelAndView("itemsPager");
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		/**
		 * 分頁商品
		 */
		Pager<Item> pager = itemService.findByKeyWord(keyWord);
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
