package com.charitybuzz.web.cb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contact_us")
public class ContactsController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(ContactsController.class);

	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView indexPage() {
		ModelAndView mav = new ModelAndView("contact_us");
		
		return mav;
	}
	@RequestMapping(value = "/item/{itemId}/index",method = RequestMethod.GET)
	public ModelAndView itemPage(@PathVariable Long itemId) {
		ModelAndView mav = new ModelAndView("contact_us");

		return mav;
	}

	
}
