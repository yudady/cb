package com.charitybuzz.web.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.SubCategory;
import com.charitybuzz.service.CategoryService;
import com.charitybuzz.service.SubCategoryService;
import com.charitybuzz.web.form.CategoryForm;

@Controller
@RequestMapping(value = "/manager/category")
@SessionAttributes({ "operator" })
public class CategoryManager {

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
	 * 拿到列表
	 * 
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView categoryList() {
		ModelAndView mav = new ModelAndView("manager/category/list");

		Pager<Category> categories = categoryService.findPager();
		mav.addObject("categories", categories);

		List<Category> datas = categories.getDatas();
		for (int i = 0; i < datas.size(); i++) {
			Category category = datas.get(i);
			Long categoryId = category.getId();
			List<SubCategory> subCategories = subCategoryService
					.findByCategoryId(categoryId);
			category.setSubCategories(subCategories);
		}
		return mav;
	}

	/**
	 * 拿到add page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView categoryAddPage() {
		ModelAndView mav = new ModelAndView("manager/category/add");
		return mav;
	}

	/**
	 * 新增
	 * 
	 * @param form
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView categoryAdd(CategoryForm form, BindingResult result) {

		if (result.hasErrors()) {
			throw new RuntimeException("驗證錯誤");
		}

		categoryService.insert(new Category(form.getName()));
		ModelAndView mav = new ModelAndView(
				"redirect:/manager/category/list.do");
		return mav;
	}

	/**
	 * 拿到update page
	 * 
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "{categoryId}/update", method = RequestMethod.GET)
	public ModelAndView categoryUpdatePage(@PathVariable Long categoryId) {
		ModelAndView mav = new ModelAndView("manager/category/update");

		Category category = categoryService.findById(categoryId);
		mav.addObject("category", category);
		return mav;
	}

	/**
	 * update
	 * 
	 * @param categoryId
	 * @param form
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "{categoryId}/update", method = RequestMethod.POST)
	public ModelAndView categoryUpdate(@PathVariable Long categoryId,
			CategoryForm form, BindingResult result) {
		if (result.hasErrors()) {
			throw new RuntimeException("驗證錯誤");
		}
		categoryService.update(new Category(form.getId(), form.getName()));

		ModelAndView mav = new ModelAndView(
				"redirect:/manager/category/list.do");
		return mav;
	}

	/**
	 * delete
	 * 
	 * @param categoryId
	 * @param form
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "{categoryId}/delete", method = RequestMethod.GET)
	public ModelAndView categoryDelete(@PathVariable Long categoryId,
			CategoryForm form, BindingResult result) {
		if (result.hasErrors()) {
			throw new RuntimeException("驗證錯誤");
		}

		categoryService.delete(categoryId);

		ModelAndView mav = new ModelAndView(
				"redirect:/manager/category/list.do");
		return mav;
	}

}
