package com.charitybuzz.web.cb.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Category;
import com.charitybuzz.operate.SidebarService;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
	@Resource
	private SidebarService sidebarService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("index");

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
		pager.setTotalRecord(100);

		
		
		
		
		
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		mav.addObject("pager", pager);

		return mav;

	}

}
