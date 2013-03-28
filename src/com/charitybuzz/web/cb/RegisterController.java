package com.charitybuzz.web.cb;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charitybuzz.cache.SidebarService;
import com.charitybuzz.dto.Bidder;
import com.charitybuzz.dto.Category;
import com.charitybuzz.service.BidderService;
import com.charitybuzz.web.form.BidderForm;

/**
 * 註冊
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(RegisterController.class);

	/**
	 * 目錄
	 */
	@Resource
	private SidebarService sidebarService;
	/**
	 * 投標者
	 */
	@Resource
	private BidderService bidderService;

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView page(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("cb/register");
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getCategories();
		mav.addObject("categories", categories);

		return mav;
	}

	/**
	 * 註冊
	 * 
	 * @param form
	 * @param result
	 * @param session
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ModelAndView loginForm(BidderForm form, BindingResult result,
			HttpSession session, RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView("redirect:/");
		log.debug("[LOG]form=" + form);

		Bidder bidder = new Bidder();
		BeanUtils.copyProperties(form, bidder);
		bidderService.insert(bidder);

		return mav;

	}

}
