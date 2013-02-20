package com.charitybuzz.web.cb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.dto.Bidlog;
import com.charitybuzz.dto.Category;
import com.charitybuzz.operate.SidebarService;
import com.charitybuzz.service.BidlogService;

@Controller
@RequestMapping("/item")

public class BidslogController {
	/** logger. */
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	

	@Resource
	private SidebarService sidebarService;
	/**
	 * 商品log
	 */
	@Resource
	private BidlogService bidlogService;
	/**
	 * 歷史紀錄
	 * @param bidder
	 * @param form
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value = "/{itemId}/bidslog", method = RequestMethod.GET)
	public ModelAndView bidderlog(@PathVariable Long itemId) {
		log.debug("[LOG][itemId][bidlog]=" + itemId);

		ModelAndView mav = new ModelAndView("bidslog");
		
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		
		
		
		List<Bidlog> bidlogs = bidlogService.findByItemId(itemId);
		log.debug("[LOG]" + bidlogs.size());
		mav.addObject("bidlogs", bidlogs);
		return mav;
	}

}
