package com.charitybuzz.web.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.session.SessionObject;
import com.charitybuzz.web.manager.form.CategoryForm;

@Controller
@RequestMapping(value = "/manager/category")
@SessionAttributes({ "sessionObject" })
public class CategoryController {

	@RequestMapping(value = "/list")
	public ModelAndView categoryList(CategoryForm form,
			@ModelAttribute("sessionObject") SessionObject sessionObject) {
		ModelAndView mav = new ModelAndView("manager/manager/list");
		return mav;
	}

	@RequestMapping(value = "/add")
	public ModelAndView categoryAdd(
			@ModelAttribute("sessionObject") SessionObject sessionObject) {
		ModelAndView mav = new ModelAndView("manager/manager/add");
		return mav;
	}

	@RequestMapping(value = "/update")
	public ModelAndView categoryUpdate(
			@ModelAttribute("sessionObject") SessionObject sessionObject) {
		ModelAndView mav = new ModelAndView("manager/manager/update");
		return mav;
	}

}
