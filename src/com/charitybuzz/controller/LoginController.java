package com.charitybuzz.controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.charitybuzz.common.session.SessionObject;
import com.charitybuzz.controller.form.LoginForm;
import com.charitybuzz.domain.Bidder;
import com.charitybuzz.domain.Category;
import com.charitybuzz.domain.Operator;
import com.charitybuzz.operate.SidebarService;
import com.charitybuzz.service.BidderService;
import com.charitybuzz.service.OperatorService;

@Controller
@RequestMapping("/login")
public class LoginController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(LoginController.class);

	@Resource
	private SidebarService sidebarService;

	@Resource
	private BidderService bidderService;
	@Resource
	private OperatorService operatorService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView page(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("login");
		List<Category> categories = sidebarService.getSidebar();
		mav.addObject("categories", categories);

		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
		if (map != null) {
			log.debug("[LOG][redirect]" + map);
		}

		return mav;
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public ModelAndView loginForm(LoginForm form, BindingResult result,
			HttpSession session, RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("redirect:" + "/login.do");
			return mav;
		}

		String email = form.getEmail();
		String passWord = form.getPassWord();
		String url = form.getUrl();

		Bidder bidder = bidderService.findByEmail(email);
		if (bidder == null) {
			// 是否manager Login
			Operator operator = operatorService.findByName(email);
			if (operator != null) {
				if ((operator.getPassWord()).equals(passWord)) {
					session.setAttribute("sessionObject", new SessionObject(
							true, email));
					mav.setViewName("redirect:" + url);
					return mav;
				}
			}

			redirectAttributes.addFlashAttribute("errorMsg", "email error")
					.addFlashAttribute("url", url);
			mav.setViewName("redirect:" + "/login.do");
		} else if (!(bidder.getPassWord()).equals(passWord)) {
			redirectAttributes.addFlashAttribute("errorMsg", "password error")
					.addFlashAttribute("url", url);
			mav.setViewName("redirect:" + "/login.do");
		} else {
			session.setAttribute("sessionObject", new SessionObject(false,
					email));
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
