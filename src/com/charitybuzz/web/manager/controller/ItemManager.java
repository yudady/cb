package com.charitybuzz.web.manager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.SubCategory;
import com.charitybuzz.operate.SidebarService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.SubCategoryService;
import com.charitybuzz.service.SubcategoryItemService;
import com.charitybuzz.web.manager.form.ItemForm;

@Controller
@RequestMapping(value = "/manager/item")
@SessionAttributes(value = { "operator" })
public class ItemManager {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(SubCategoryManager.class);

	/**
	 * 商品
	 */
	@Resource
	private ItemService itemService;
	/**
	 * 第二級目錄
	 */
	@Resource
	private SubCategoryService subCategoryService;
	@Resource
	private SubcategoryItemService subcategoryItemService;
	@Resource
	private SidebarService sidebarService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	/**
	 * 拿到列表
	 * 
	 * @param form
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView itemList(ItemForm form) {
		ModelAndView mav = new ModelAndView("manager/item/list");
		List<Item> items = itemService.findAll();
		mav.addObject("items", items);
		return mav;
	}

	/**
	 * 拿到add page
	 * 
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView itemAddPage() {
		ModelAndView mav = new ModelAndView("manager/item/add");
		List<SubCategory> subCategories = subCategoryService.findAll();
		mav.addObject("subCategories", subCategories);
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
	public ModelAndView itemAdd(ItemForm form, BindingResult result) {

		if (result.hasErrors()) {
			// TODO fix error msg
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {

				log.error("result.hasErrors" + error);
			}
		}
		
		
		synchronized (sidebarService) {
			log.debug("[LOG]ItemForm=" + form);
			Long itemId = itemService.insert(new Item(form.getTitle(), form
					.getCurrentBid(), form.getStartDate(), form.getCloseDate(),
					form.getEstimatedValue(), form.getIncrementPrice(), form
							.getStatus(), form.getLotDetails(), form
							.getLegalTerms(), form.getShipping(), form
							.getWinningBidderId()));
			
			
			subcategoryItemService.insert(itemId,form.getSubCategoryIds());
			sidebarService.setCategories(null);
		}

		
		
		ModelAndView mav = new ModelAndView("redirect:/manager/item/list.do");
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
	public ModelAndView itemUpdatePage(@PathVariable Long itemId) {
		ModelAndView mav = new ModelAndView("manager/item/update");
		List<SubCategory> subCategories = subCategoryService.findAll();
		mav.addObject("subCategories", subCategories);
		Item item = itemService.findById(itemId);
		mav.addObject("item", item);

		List<SubCategory> subCas = subCategoryService.findByItemd(itemId);
		for (SubCategory subCategory : subCategories) {

			for (SubCategory subCa : subCas) {
				if (subCategory.getId() == subCa.getId()) {
					subCategory.setItemCheckedMark("checked");
				}
			}
		}

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
	public ModelAndView itemUpdate(ItemForm form, BindingResult result) {
		if (result.hasErrors()) {
			// TODO fix error msg
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {

				log.error("result.hasErrors" + error);
			}
		}
		
		
		synchronized (sidebarService) {
			log.debug("[LOG]ItemForm=" + form);
			itemService.update(new Item(form.getItemIdForm(), form.getTitle(), form
					.getCurrentBid(), form.getStartDate(), form.getCloseDate(),
					form.getEstimatedValue(), form.getIncrementPrice(), form
							.getStatus(), form.getLotDetails(), form
							.getLegalTerms(), form.getShipping(), form
							.getWinningBidderId()));
			
			
			subcategoryItemService.update(form.getItemIdForm(),form.getSubCategoryIds());
			sidebarService.setCategories(null);
		}
		
		
		


		ModelAndView mav = new ModelAndView("redirect:/manager/item/list.do");
		return mav;
	}

	@RequestMapping(value = "{itemId}/delete", method = RequestMethod.GET)
	public ModelAndView itemDelete(@PathVariable Long itemId) {
		itemService.delete(itemId);
		ModelAndView mav = new ModelAndView("redirect:/manager/item/list.do");
		return mav;
	}

}
