package com.charitybuzz.web.cb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auctions")
public class AuctionsController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(AuctionsController.class);

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView auctions() {
		ModelAndView mav = new ModelAndView("itemsPager");
		return mav;
	}

}
