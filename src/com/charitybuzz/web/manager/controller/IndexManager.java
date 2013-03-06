package com.charitybuzz.web.manager.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.dto.Operator;
import com.charitybuzz.service.OperatorService;
import com.charitybuzz.web.form.LoginForm;

@Controller
@RequestMapping(value = "/manager")
public class IndexManager {

	@Resource
	private OperatorService operatorService;
	
	/**
	 * index 頁面
	 * @return
	 */
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("manager/index");
		return mav;

	}
	/**
	 * 是否登入成功
	 * 成功 add sessionObject
	 * @param form
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/index",method = RequestMethod.POST)
	public ModelAndView loginForm(LoginForm form,HttpSession session) {
		ModelAndView mav = new ModelAndView("manager/index");
		// 是否manager Login
		Operator operator = operatorService.findByName(form.getName());
		if (operator != null) {
			if ((operator.getPassWord()).equals(form.getPassWord())) {
				session.setAttribute("operator", operator);
			}
		}
		return mav;
		
	}
	@RequestMapping(value = "/loginOut", method = RequestMethod.POST)
	public ModelAndView loginOut(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String url = request.getParameter("url");
		session.removeAttribute("operator");
		mav.setViewName("redirect:" + url);
		return mav;

	}
}
