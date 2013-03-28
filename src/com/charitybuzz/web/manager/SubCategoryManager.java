package com.charitybuzz.web.manager;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.SubCategory;
import com.charitybuzz.service.CategoryService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.SubCategoryService;
import com.charitybuzz.web.form.SubCategoryForm;

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
	 * 拿到列表，第二級目錄下有商品，則不能刪除
	 * 
	 * @param form
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView subCategoryList(SubCategoryForm form) {
		log.debug("[LOG][subCategoryList]");
		ModelAndView mav = new ModelAndView("manager/subcategory/list");
		
		
		Pager<SubCategory> subCategories = subCategoryService.findPager();
		mav.addObject("subCategories", subCategories);
		List<SubCategory> datas = subCategories.getDatas();
		/**
		 * 第二級目錄
		 */
		for (int j = 0; j < datas.size(); j++) {
			SubCategory subs = datas.get(j);
			List<Item> items = itemService.findBySubCategoryId(subs.getId());
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
			throw new RuntimeException("驗證錯誤");
		}
		subCategoryService.insert(new SubCategory(form.getSubCaId(), form
				.getCategoryId(), form.getName()));

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
			throw new RuntimeException("驗證錯誤");
		}
		SubCategory sc = new SubCategory(form.getSubCaId(),
				form.getCategoryId(), form.getName());
		subCategoryService.update(sc);

		ModelAndView mav = new ModelAndView(
				"redirect:/manager/subcategory/list.do");
		return mav;
	}

	@RequestMapping(value = "{subCategoryId}/delete", method = RequestMethod.GET)
	public ModelAndView categoryDelete(@PathVariable Long subCategoryId,
			SubCategoryForm form, BindingResult result) {
		if (result.hasErrors()) {
			throw new RuntimeException("驗證錯誤");
		}

		subCategoryService.delete(subCategoryId);

		ModelAndView mav = new ModelAndView(
				"redirect:/manager/subcategory/list.do");
		return mav;
	}

}
