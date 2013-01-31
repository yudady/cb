package com.charitybuzz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/index.do")
public class IndexController {
	
	/** logger. */
	private Logger log = LoggerFactory.getLogger(IndexController.class);
	
	//@RequestMapping(method = RequestMethod.GET)
	@RequestMapping()
	public String index(ModelMap model) {
		log.debug("[LOG]log IndexController.index");
		System.out.println("[LOG]System IndexController.index");
		return "index";
				
	}
	
}
