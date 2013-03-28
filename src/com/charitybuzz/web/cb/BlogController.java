package com.charitybuzz.web.cb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(BlogController.class);
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView indexPage() {
		ModelAndView mav = new ModelAndView("blog");
		log.debug("[LOG][blog]");
		return mav;
	}
	
	
	

}
