package com.charitybuzz.web.cb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dogooddreambig")
public class DoGoodDreamBigController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(DoGoodDreamBigController.class);
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView indexPage() {
		ModelAndView mav = new ModelAndView("doGoodDreamBig");
		log.debug("[LOG][dogooddreambig]");
		return mav;
	}
	
	
	

}
