package com.charitybuzz.web.cb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/testimonials")
public class TestimonialsController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(TestimonialsController.class);
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView indexPage() {
		ModelAndView mav = new ModelAndView("testimonials");
		log.debug("[LOG][testimonials]");
		return mav;
	}
	
	
	

}
