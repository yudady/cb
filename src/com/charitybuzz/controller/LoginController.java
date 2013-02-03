package com.charitybuzz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.session.SessionObject;

@Controller
@RequestMapping("/login")
public class LoginController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,HttpSession session) {
		String email = request.getParameter("email");
		String passWord = request.getParameter("passWord");
		String url = request.getParameter("url");
		log.debug("[LOG]email" + email);
		log.debug("[LOG]passWord" + passWord);
		log.debug("[LOG]url" + url);
		session.setAttribute("sessionObject", new SessionObject(email));
		return new ModelAndView("redirect:" + url);

	}

}
