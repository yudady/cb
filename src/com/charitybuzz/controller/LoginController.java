package com.charitybuzz.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charitybuzz.common.session.SessionObject;
import com.charitybuzz.domain.Bidder;
import com.charitybuzz.domain.Category;
import com.charitybuzz.operate.SidebarService;
import com.charitybuzz.service.BidderService;

@Controller
@RequestMapping("/login")
public class LoginController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(LoginController.class);

	@Resource
	private SidebarService sidebarService;
	
	@Resource
	private BidderService bidderService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("login");
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);
		return mav;
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public ModelAndView loginForm(HttpServletRequest request,
			HttpSession session,RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView();

		String email = request.getParameter("email");
		String passWord = request.getParameter("passWord");
		String url = request.getParameter("url");
		log.debug("[LOG]email" + email);
		log.debug("[LOG]passWord" + passWord);
		log.debug("[LOG]url" + url);

		Bidder bidder = bidderService.findByEmail(email);
		if (bidder == null) {
			redirectAttributes.addFlashAttribute("errorMsg", "password error");
			redirectAttributes.addFlashAttribute("url", url);
			mav.setViewName("redirect:" + "/login.do");
		} else if (!(bidder.getPassWord()).equals(passWord)) {
			redirectAttributes.addFlashAttribute("errorMsg", "password error");
			redirectAttributes.addFlashAttribute("url", url);
			mav.setViewName("redirect:" + "/login.do");
		} else {
			session.setAttribute("sessionObject", new SessionObject(email));
			mav.setViewName("redirect:" + url);
		}
		return mav;

	}

	@RequestMapping(value = "/loginOut", method = RequestMethod.POST)
	public ModelAndView loginOut(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String url = request.getParameter("url");
		log.debug("[LOG]url" + url);
		session.removeAttribute("sessionObject");
		mav.setViewName("redirect:" + url);
		return mav;

	}

}
