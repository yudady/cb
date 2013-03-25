package com.charitybuzz.web.manager.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Operator;
import com.charitybuzz.service.OperatorService;
import com.charitybuzz.web.form.OperatorForm;

@Controller
@RequestMapping(value = "/manager/operator")
@SessionAttributes({ "operator" })
public class OperatorManager {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(OperatorManager.class);

	/**
	 * 商品
	 */
	@Resource
	private OperatorService operatorService;

	/**
	 * 拿到列表
	 * 
	 * @param form
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView operatorList(OperatorForm form) {
		ModelAndView mav = new ModelAndView("manager/operator/list");
		
		Pager<Operator> operators = operatorService.findPager();
		mav.addObject("operators", operators);
		return mav;
	}

	/**
	 * 拿到add page
	 * 
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView operatorAddPage() {
		ModelAndView mav = new ModelAndView("manager/operator/add");
		return mav;
	}

	/**
	 * 新增
	 * 
	 * @param sessionObject
	 * @param form
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView operatorAdd(OperatorForm form, BindingResult result) {

		if (result.hasErrors()) {
			throw new RuntimeException("驗證錯誤");
		}
		
		
		Operator operator = new Operator();
		BeanUtils.copyProperties(form, operator);
		operatorService.insert(operator);

		ModelAndView mav = new ModelAndView(
				"redirect:/manager/operator/list.do");
		return mav;
	}

	/**
	 * 拿到update page
	 * 
	 * @param sessionObject
	 * @param operatorId
	 * @return
	 */
	@RequestMapping(value = "{operatorId}/update", method = RequestMethod.GET)
	public ModelAndView operatorUpdatePage(@PathVariable Long operatorId) {
		ModelAndView mav = new ModelAndView("manager/operator/update");

		Operator operatorObj = operatorService.findById(operatorId);
		mav.addObject("operatorObj", operatorObj);
		log.debug("[LOG][form]" + operatorObj);
		return mav;
	}

	/**
	 * update
	 * 
	 * @param sessionObject
	 * @param operatorId
	 * @return
	 */
	@RequestMapping(value = "{operatorId}/update", method = RequestMethod.POST)
	public ModelAndView operatorUpdate(@PathVariable Long operatorId,
			OperatorForm form, BindingResult result) {
		if (result.hasErrors()) {
			throw new RuntimeException("驗證錯誤");
		}

		log.debug("[LOG][form]" + form);
		Operator operator = new Operator();
		BeanUtils.copyProperties(form, operator);
		operatorService.update(operator);
		ModelAndView mav = new ModelAndView(
				"redirect:/manager/operator/list.do");
		return mav;
	}

	@RequestMapping(value = "{operatorId}/delete", method = RequestMethod.GET)
	public ModelAndView operatorDelete(@PathVariable Long operatorId,
			OperatorForm form, BindingResult result) {
		if (result.hasErrors()) {
			throw new RuntimeException("驗證錯誤");
		}

		operatorService.delete(operatorId);

		ModelAndView mav = new ModelAndView(
				"redirect:/manager/operator/list.do");
		return mav;
	}

}
