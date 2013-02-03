package com.charitybuzz.web.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.session.SessionObject;

@Controller
@RequestMapping(value = "/manager")
@SessionAttributes({ "sessionObject" })
public class ManagerController {

	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView index(
			@ModelAttribute("sessionObject") SessionObject sessionObject) {
		ModelAndView mav = new ModelAndView("manager/index");
		return mav;

	}

}
