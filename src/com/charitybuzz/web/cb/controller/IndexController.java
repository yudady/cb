package com.charitybuzz.web.cb.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.operate.SidebarService;
import com.charitybuzz.service.ItemService;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
	/** logger. */
	private Logger log = LoggerFactory.getLogger(IndexController.class);
	@Resource
	private SidebarService sidebarService;

	
	
	/**
	 * 全部商品
	 */
	@Resource
	private ItemService itemService;
	
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(HttpSession session) {
		ModelAndView mav = new ModelAndView("index");

		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);

		return mav;

	}
	
	/**
	 * 要到期的商品
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/closingNext", method = RequestMethod.GET)
	public ModelAndView closingNext(HttpSession session) {
		ModelAndView mav = new ModelAndView("indexTabs/closeNext4Tab");
		
		List<Item> items = itemService.findAll();
		mav.addObject("items", items);
		return mav;
		
	}
	/**
	 * 差價最大
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/hotDeals", method = RequestMethod.GET)
	public ModelAndView hotDeals(HttpSession session) {
		ModelAndView mav = new ModelAndView("indexTabs/hotDeals4Tab");
		
		List<Item> items = itemService.findAll();
		mav.addObject("items", items);
		return mav;
		
	}
	/**
	 * 最受歡迎
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/popular", method = RequestMethod.GET)
	public ModelAndView popular(HttpSession session) {
		ModelAndView mav = new ModelAndView("indexTabs/popular4Tab");
		
		List<Item> items = itemService.findAll();
		mav.addObject("items", items);
		return mav;
		
	}
	/**
	 * 新進商品
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/recentAdd", method = RequestMethod.GET)
	public ModelAndView recentAdd(HttpSession session) {
		ModelAndView mav = new ModelAndView("indexTabs/recentAdd4Tab");
		
		List<Item> items = itemService.findAll();
		mav.addObject("items", items);
		return mav;
		
	}

}
