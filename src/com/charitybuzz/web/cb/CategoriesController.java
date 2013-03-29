package com.charitybuzz.web.cb;

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

/**
 * 點擊menu bar
 * 
 * @author Administrator
 * 
 */
@Controller
public class CategoriesController {
	/** logger. */
	private Logger log = LoggerFactory.getLogger(CategoriesController.class);

	/**
	 * 左邊menu bar
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
	/**
	 * 歷史紀錄
	 */
	@Resource
	private BidlogService bidlogService;

	/**
	 * 第一層目錄
	 * 
	 * @param categoryId
	 * @param categoryName
	 * @return
	 */
	@RequestMapping(value = "/categories/{categoryId}/{categoryName}/index", method = RequestMethod.GET)
	public ModelAndView category(@PathVariable Long categoryId,
			@PathVariable String categoryName) {
		ModelAndView mav = new ModelAndView("cb/itemsPager");

		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getCategories();
		mav.addObject("categories", categories);

		/**
		 * 分頁商品
		 */
		Pager<Item> pager = itemService.findPagerByCategoryId(categoryId);
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

	/**
	 * 第二層目錄
	 * 
	 * @param categoryId
	 * @param categoryName
	 * @param subcategoryId
	 * @param subCategoryName
	 * @return
	 */
	@RequestMapping(value = "/categories/{categoryId}/{categoryName}/subcategories/{subcategoryId}/{subCategoryName}/index", method = RequestMethod.GET)
	public ModelAndView subCategory(@PathVariable Long categoryId,
			@PathVariable String categoryName,
			@PathVariable Long subcategoryId,
			@PathVariable String subCategoryName) {

		log.debug("[LOG][subcategoryId]" + subcategoryId);

		ModelAndView mav = new ModelAndView("cb/itemsPager");
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getCategories();
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
	 * 全部商品
	 * 
	 * @return
	 */
	@RequestMapping(value = "/categories/viewall", method = RequestMethod.GET)
	public ModelAndView viewAll() {

		ModelAndView mav = new ModelAndView("cb/itemsPager");
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getCategories();
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

	/**
	 * 尋找商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/categories/searchItems", method = RequestMethod.POST)
	public ModelAndView searchItems(HttpServletRequest request) {

		log.debug("[LOG][searchItems]");
		String keyWord = request.getParameter("search");
		ModelAndView mav = new ModelAndView("cb/itemsPager");
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getCategories();
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
