package com.charitybuzz.web.cb.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.charitybuzz.cache.SidebarService;
import com.charitybuzz.dto.Bidder;
import com.charitybuzz.dto.Category;
import com.charitybuzz.service.BidderService;
import com.charitybuzz.web.form.BidderLoginForm;

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
	public ModelAndView page(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("login");
		List<Category> categories = sidebarService.getCategories();
		mav.addObject("categories", categories);

		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
		if (map != null) {
			log.debug("[LOG][redirect]" + map);
		}

		return mav;
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public ModelAndView loginForm(BidderLoginForm form, BindingResult result,
			HttpSession session, RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			log.debug("[LOG][LoginForm]" + form);
			mav.setViewName("redirect:" + "/login.do");
			return mav;
		}

		String email = form.getEmail();
		String passWord = form.getPassWord();
		log.debug("[LOG][email]" + email);
		log.debug("[LOG][passWord]" + passWord);
		Bidder bidder = bidderService.findByEmail(email);
		if (bidder == null) {
			/*
			 * email error
			 */
			redirectAttributes.addFlashAttribute("errorMsg", "email error");
			mav.setViewName("redirect:" + "/login.do");
		} else if (!(bidder.getPassWord()).equals(passWord)) {
			/*
			 * password error
			 */
			redirectAttributes.addFlashAttribute("errorMsg", "password error");
			mav.setViewName("redirect:" + "/login.do");
		} else {
			/*
			 * success
			 */
			session.setAttribute("bidder", bidder);
			mav.setViewName("redirect:/");
		}
		return mav;

	}

	@RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
	public @ResponseBody String ajaxLogin(BidderLoginForm form, BindingResult result,
			HttpSession session, RedirectAttributes redirectAttributes) {
		log.debug("[LOG][ajaxLogin]");

		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			log.debug("[LOG][LoginForm]" + form);
			mav.setViewName("redirect:" + "/login.do");
			return "";
		}

		String email = form.getEmail();
		String passWord = form.getPassWord();
		log.debug("[LOG][email]" + email);
		log.debug("[LOG][passWord]" + passWord);
		Bidder bidder = bidderService.findByEmail(email);
		if (bidder == null) {
		} else if (!(bidder.getPassWord()).equals(passWord)) {
		} else {
			/*
			 * success
			 */
			session.setAttribute("bidder", bidder);
			mav.setViewName("redirect:/");
		}
		return "";

	}

	@RequestMapping(value = "/ajaxLoginOut", method = RequestMethod.POST)
	public @ResponseBody
	String ajaxLoginOut(HttpSession session) {
		log.debug("[LOG][ajaxLoginOut]");
		session.removeAttribute("bidder");
		return "success";
	}

}
