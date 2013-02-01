package com.charitybuzz.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.domain.Category;
import com.charitybuzz.operate.SidebarService;


@Controller
@RequestMapping(value = "/index")
public class IndexController {
	
	/** logger. */
	private Logger log = LoggerFactory.getLogger(IndexController.class);
	
	
	@Resource
	private SidebarService sidebarService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(HttpSession session) {
		ModelAndView mav = new ModelAndView("index");
		
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		
		
		return mav;
				
	}
	
}
