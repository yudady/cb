package com.charitybuzz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.domain.Item;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
	/** logger. */
	private Logger log = LoggerFactory.getLogger(this.getClass());

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
	 * categories/2
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/index", method = RequestMethod.GET)
	public ModelAndView fir(@PathVariable Long id) {
		log.debug("[LOG][id]=" + id);
		log.debug("[LOG][id]=" + id);
		log.debug("[LOG][id]=" + id);
		log.debug("[LOG][id]=" + id);
		log.debug("[LOG][id]=" + id);
		log.debug("[LOG][id]=" + id);
		ModelAndView mav = new ModelAndView("items");
		
		/**
		 * 全部商品
		 */
		List<Item> items = itemService.findByCategoryId(id);

//		for (Item item : items) {
//
//			Long itemId = item.getId();
//			List<Picture> pictures = pictureService.findPictureByitemId(itemId);
//			item.setPictures(pictures);
//			log.debug("[pic]" + item.getMainPictureLocation());
//		}

		log.debug(items.toString());
		return mav;
	}

	/**
	 * categories/2/subcategories/14
	 * 
	 * @param categoryId
	 * @param subcategoryId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{categoryId}/subcategories/{subcategoryId}", method = RequestMethod.GET)
	public String sec(@PathVariable Long categoryId,
			@PathVariable Long subcategoryId, Model model) {
		log.debug("[categories][id]=" + categoryId);

		/**
		 * 全部商品
		 */
		List<Item> items = itemService.findBySubCategoryId(subcategoryId);

//		for (Item item : items) {
//
//			Long itemId = item.getId();
//			List<Picture> pictures = pictureService.findPictureByitemId(itemId);
//			item.setPictures(pictures);
//			log.debug("[pic]" + item.getMainPictureLocation());
//		}
		model.addAttribute("items", items);

		log.debug(items.toString());
		return "items";
	}

}
