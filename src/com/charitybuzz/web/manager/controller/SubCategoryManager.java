package com.charitybuzz.web.manager.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.SubCategory;
import com.charitybuzz.service.CategoryService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.SubCategoryService;
import com.charitybuzz.web.manager.form.SubCategoryForm;

@Controller
@RequestMapping(value = "/manager/subcategory")
@SessionAttributes({ "sessionObject" })
public class SubCategoryManager {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(SubCategoryManager.class);

	/**
	 * 第一級目錄
	 */
	@Resource
	private CategoryService categoryService;
	/**
	 * 第二級目錄
	 */
	@Resource
	private SubCategoryService subCategoryService;
	
	/**
	 * 全部商品
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
	public ModelAndView SubCategoryList(SubCategoryForm form) {
		ModelAndView mav = new ModelAndView("manager/subcategory/list");
		List<SubCategory> subCategories = subCategoryService.findAll();
		mav.addObject("subCategories", subCategories);
		
		/**
		 * 第二級目錄
		 */
		for (int j = 0; j < subCategories.size(); j++) {
			SubCategory subs = subCategories.get(j);
			List<Item> items = itemService.findBySubCategoryId(subs
					.getId());
			subs.setItems(items);
		}
		
		
		
		
		return mav;
	}

	/**
	 * 拿到add page
	 * 
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView subCategoryAddPage() {
		ModelAndView mav = new ModelAndView("manager/subcategory/add");
		List<Category> categories = categoryService.findAll();
		mav.addObject("categories", categories);
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
	public ModelAndView subCategoryAdd(SubCategoryForm form,
			BindingResult result) {

		if (result.hasErrors()) {
		}

		subCategoryService.insert(new SubCategory(form.getSubCaId(), form
				.getCategoryId(), form.getName(), form.getDescript()));

		ModelAndView mav = new ModelAndView(
				"redirect:/manager/subcategory/list.do");
		return mav;
	}

	/**
	 * 拿到update page
	 * 
	 * @param sessionObject
	 * @param subcategoryId
	 * @return
	 */
	@RequestMapping(value = "{subCategoryId}/update", method = RequestMethod.GET)
	public ModelAndView subCategoryUpdatePage(@PathVariable Long subCategoryId) {
		ModelAndView mav = new ModelAndView("manager/subcategory/update");
		List<Category> categories = categoryService.findAll();
		mav.addObject("categories", categories);
		SubCategory subCategory = subCategoryService.findById(subCategoryId);
		mav.addObject("subCategory", subCategory);
		return mav;
	}

	/**
	 * update
	 * 
	 * @param sessionObject
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "{subCategoryId}/update", method = RequestMethod.POST)
	public ModelAndView categoryUpdate(SubCategoryForm form,
			BindingResult result) {
		if (result.hasErrors()) {
		}

		SubCategory sc = new SubCategory(form.getSubCaId(),
				form.getCategoryId(), form.getName(), form.getDescript());
		subCategoryService.update(sc);

		ModelAndView mav = new ModelAndView(
				"redirect:/manager/subcategory/list.do");
		return mav;
	}

	@RequestMapping(value = "{subCategoryId}/delete", method = RequestMethod.GET)
	public ModelAndView categoryDelete(@PathVariable Long subCategoryId,
			SubCategoryForm form, BindingResult result) {
		if (result.hasErrors()) {
		}

		subCategoryService.delete(subCategoryId);

		ModelAndView mav = new ModelAndView(
				"redirect:/manager/subcategory/list.do");
		return mav;
	}

	@ExceptionHandler({ HttpSessionRequiredException.class })
	public ModelAndView noSessionObject(Exception ex) {
		return new ModelAndView("redirect:/manager/index.do");
	}
}
