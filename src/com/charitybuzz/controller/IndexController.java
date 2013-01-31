package com.charitybuzz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/index")
public class IndexController {
	
	/** logger. */
	private Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		log.debug("[LOG]log IndexController.index");
		return "index";
				
	}
	
}
