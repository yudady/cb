package com.charitybuzz.web.cb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.dto.Auction;
import com.charitybuzz.dto.Category;
import com.charitybuzz.operate.SidebarService;
import com.charitybuzz.service.AuctionService;

@Controller
@RequestMapping("/auctions")
public class AuctionsController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(AuctionsController.class);
	/**
	 * 目錄
	 */
	@Resource
	private SidebarService sidebarService;
	/**
	 * 拍賣會
	 */
	@Resource
	private AuctionService auctionService;
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView indexPage() {
		ModelAndView mav = new ModelAndView("auctions");
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		
		List<Auction> auctions = auctionService.findAll();
		mav.addObject("auctions", auctions);
		
		
		
		return mav;
	}
	
	
	
	

}
