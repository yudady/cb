package com.charitybuzz.web.manager;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Bidder;
import com.charitybuzz.service.BidderService;
import com.charitybuzz.web.form.BidderForm;

@Controller
@RequestMapping(value = "/manager/bidder")
@SessionAttributes({ "operator" })
public class BidderManager {

	/**
	 * 投標者
	 */
	@Resource
	private BidderService bidderService;

	/**
	 * 拿到列表
	 * 
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView bidderList() {
		ModelAndView mav = new ModelAndView("manager/bidder/list");

		Pager<Bidder> bidders = bidderService.findPager();
		mav.addObject("bidders", bidders);

		return mav;
	}

	/**
	 * 拿到add page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView bidderAddPage() {
		ModelAndView mav = new ModelAndView("manager/bidder/add");
		return mav;
	}

	/**
	 * 新增
	 * 
	 * @param form
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView bidderAdd(BidderForm form, BindingResult result) {

		if (result.hasErrors()) {
			throw new RuntimeException("驗證錯誤");
		}
		Bidder bidder = new Bidder();
		BeanUtils.copyProperties(form, bidder);
		bidderService.insert(bidder);
		ModelAndView mav = new ModelAndView("redirect:/manager/bidder/list.do");
		return mav;
	}

	/**
	 * 拿到update page
	 * 
	 * @param sessionObject
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "{bidderId}/update", method = RequestMethod.GET)
	public ModelAndView categoryUpdatePage(@PathVariable Long bidderId) {
		ModelAndView mav = new ModelAndView("manager/bidder/update");

		Bidder bidder = bidderService.findById(bidderId);
		mav.addObject("bidder", bidder);
		return mav;
	}

	/**
	 * update
	 * 
	 * @param sessionObject
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "{bidderId}/update", method = RequestMethod.POST)
	public ModelAndView categoryUpdate(@PathVariable Long bidderId,
			BidderForm form, BindingResult result) {
		if (result.hasErrors()) {
			throw new RuntimeException("驗證錯誤");
		}

		Bidder bidder = new Bidder();
		BeanUtils.copyProperties(form, bidder);

		bidderService.update(bidder);

		ModelAndView mav = new ModelAndView("redirect:/manager/bidder/list.do");
		return mav;
	}

	/**
	 * delete
	 * 
	 * @param categoryId
	 * @param form
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "{bidderId}/delete", method = RequestMethod.GET)
	public ModelAndView categoryDelete(@PathVariable Long bidderId) {

		bidderService.delete(bidderId);

		ModelAndView mav = new ModelAndView("redirect:/manager/bidder/list.do");
		return mav;
	}
}
