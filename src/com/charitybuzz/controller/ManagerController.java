package com.charitybuzz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.session.SessionObject;
import com.charitybuzz.domain.Category;
import com.charitybuzz.operate.SidebarService;

@Controller
@RequestMapping(value = "/manager")
@SessionAttributes({"sessionObject"})
public class ManagerController {

	@Resource
	private SidebarService sidebarService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("sessionObject") SessionObject sessionObject) {
		ModelAndView mav = new ModelAndView("manager");

		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);

		return mav;

	}

}
