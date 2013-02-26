package com.charitybuzz.web.cb.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.Constant;
import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.operate.SidebarService;
import com.charitybuzz.operate.SlideshowService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
	@Resource
	private SidebarService sidebarService;
	/**
	 * 全部商品
	 */
	@Resource
	private ItemService itemService;
	/**
	 * 商品圖片
	 */
	@Resource
	private PictureService pictureService;
	
	@Resource
	private SlideshowService slideshowService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("index");
		
		
		List<Picture> topPics = slideshowService.searchPictures(10);
		mav.addObject("topPics", topPics);
//		String pagerOffset = request.getParameter("pager.offset");
//		if (StringUtils.isBlank(pagerOffset)) {
//			pagerOffset = "0";
//		}
//		System.out.println("[LOG]" + pagerOffset);
//		
//		String pageSize = request.getParameter("pageSize");
//		if (StringUtils.isBlank(pageSize)) {
//			pageSize = "10";
//		}
//		System.out.println("[LOG]" + pageSize);
		
		
		
		//System.out.println("[LOG]" + PagerContext.getPageOffset());


		Pager<Category> pager = new Pager<Category>();
		pager.setTotalRecord(30);

		
		
		
		
		
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		mav.addObject("pager", pager);

		
		
		
		
		
		List<Item> items = itemService.findByHotDeals(Constant.INDEX_TABS_ITEMS_SIZE);
		for (Item item : items) {
			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		mav.addObject("items", items);
		
		
		
		
		
		
		
		
		
		return mav;

	}

}
