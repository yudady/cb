package com.charitybuzz.web.manager.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.Constant;
import com.charitybuzz.dto.Operator;
import com.charitybuzz.service.OperatorService;
import com.charitybuzz.web.form.FileUploadForm;
import com.charitybuzz.web.form.LoginForm;

@Controller
@RequestMapping(value = "/manager")
public class IndexManager {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(IndexManager.class);

	@Resource
	private OperatorService operatorService;

	/**
	 * index 頁面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("manager/index");
		return mav;

	}

	/**
	 * 是否登入成功 成功 add sessionObject
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ModelAndView loginForm(LoginForm form, HttpSession session) {
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

	/**
	 * index tabs4 top pic 更換圖片
	 * 
	 * @param form
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/indexPic", method = RequestMethod.POST)
	public ModelAndView indexPic(FileUploadForm form) throws IOException {

		ModelAndView mav = new ModelAndView("redirect:/manager/index.do");
		log.debug("[LOG][indexPic]");
		String fileName = null;
		CommonsMultipartFile file = form.getFile();
		fileName = file.getOriginalFilename();
		fileName = fileName.substring(fileName.indexOf("."));
		if (".jpg".equalsIgnoreCase(fileName)) {

			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					Constant.UPLOAD_FOLDER_INDEX_RIGHT
							+ "sharethelove_banner.jpg"));
		}

		return mav;
	}
}
