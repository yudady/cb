package com.charitybuzz.web.manager.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.session.SessionObject;
import com.charitybuzz.dto.Item;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.web.manager.form.ItemForm;

@Controller
@RequestMapping(value = "/manager/item")
@SessionAttributes({ "sessionObject" })
public class ItemManager {

	/**
	 * 商品
	 */
	@Resource
	private ItemService itemService;

	/**
	 * 拿到列表
	 * 
	 * @param form
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView itemList(ItemForm form,
			@ModelAttribute("sessionObject") SessionObject sessionObject) {
		ModelAndView mav = new ModelAndView("manager/item/list");
		List<Item> categories = itemService.findAll();
		mav.addObject("categories", categories);
		return mav;
	}

	/**
	 * 拿到add page
	 * 
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView itemAddPage(
			@ModelAttribute("sessionObject") SessionObject sessionObject) {
		ModelAndView mav = new ModelAndView("manager/item/add");
		return mav;
	}

	/**
	 * 新增
	 * 
	 * @param sessionObject
	 * @param form
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView itemAdd(
			@ModelAttribute("sessionObject") SessionObject sessionObject,
			ItemForm form, BindingResult result) {

		if (result.hasErrors()) {
		}

		itemService.insert(new Item());

		ModelAndView mav = new ModelAndView(
				"redirect:/manager/item/list.do");
		return mav;
	}

	/**
	 * 拿到update page
	 * 
	 * @param sessionObject
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value = "{itemId}/update", method = RequestMethod.GET)
	public ModelAndView itemUpdatePage(
			@ModelAttribute("sessionObject") SessionObject sessionObject,
			@PathVariable Long itemId) {
		ModelAndView mav = new ModelAndView("manager/item/update");

		Item item = itemService.findById(itemId);
		mav.addObject("item", item);
		return mav;
	}

	/**
	 * update
	 * 
	 * @param sessionObject
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value = "{itemId}/update", method = RequestMethod.POST)
	public ModelAndView itemUpdate(
			@ModelAttribute("sessionObject") SessionObject sessionObject,
			@PathVariable Long itemId, ItemForm form,
			BindingResult result) {
		if (result.hasErrors()) {
		}

		itemService.update(new Item());

		ModelAndView mav = new ModelAndView(
				"redirect:/manager/item/list.do");
		return mav;
	}

	@RequestMapping(value = "{itemId}/delete", method = RequestMethod.GET)
	public ModelAndView itemDelete(
			@ModelAttribute("sessionObject") SessionObject sessionObject,
			@PathVariable Long itemId, ItemForm form,
			BindingResult result) {
		if (result.hasErrors()) {
		}

		itemService.delete(itemId);

		ModelAndView mav = new ModelAndView(
				"redirect:/manager/item/list.do");
		return mav;
	}

	@ExceptionHandler({ HttpSessionRequiredException.class})
	public ModelAndView noSessionObject(Exception ex) {
		return new ModelAndView("redirect:/manager/index.do");
	}
}
