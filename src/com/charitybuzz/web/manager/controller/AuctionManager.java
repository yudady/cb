package com.charitybuzz.web.manager.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.Constant;
import com.charitybuzz.dto.Auction;
import com.charitybuzz.service.AuctionService;
import com.charitybuzz.web.form.AuctionForm;

@Controller
@RequestMapping(value = "/manager/auction")
@SessionAttributes({ "auction" })
public class AuctionManager {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(AuctionManager.class);

	/**
	 * 拍賣會
	 */
	@Resource
	private AuctionService auctionService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.DATE_STYLE);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	/**
	 * 拿到拍賣會列表
	 * http://localhost:8080/cb/manager/auction/1/item/list.do
	 * @param form
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView auctionList(AuctionForm form) {
		ModelAndView mav = new ModelAndView("manager/auction/list");
		List<Auction> auctions = auctionService.findAll();
		mav.addObject("auctions", auctions);
		return mav;
	}
	
	
	/**
	 * 拿到add page
	 * 
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView auctionAddPage() {
		ModelAndView mav = new ModelAndView("manager/auction/add");
		return mav;
	}

	/**
	 * 新增
	 * 
	 * @param sessionObject
	 * @param form
	 * @param result
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView auctionAdd(AuctionForm form) throws IOException {

		Auction auction = new Auction();
		BeanUtils.copyProperties(form, auction);
		log.debug("[LOG][auction]" + auction);

		String fileName = null;
		CommonsMultipartFile file = form.getFile();
		fileName = file.getOriginalFilename();
		fileName = new Date().getTime()
				+ fileName.substring(fileName.indexOf("."));

		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
				Constant.UPLOAD_FOLDER_AUCTION + fileName));
		auction.setAuctionLogoPath(fileName);
		auctionService.insert(auction);

		ModelAndView mav = new ModelAndView("redirect:/manager/auction/list.do");
		return mav;
	}

	/**
	 * 拿到update page
	 * 
	 * @param sessionObject
	 * @param auctionId
	 * @return
	 */
	@RequestMapping(value = "{auctionId}/update", method = RequestMethod.GET)
	public ModelAndView auctionUpdatePage(@PathVariable Long auctionId) {
		ModelAndView mav = new ModelAndView("manager/auction/update");

		Auction auction = auctionService.findById(auctionId);
		mav.addObject("auction", auction);
		log.debug("[LOG][form]" + auction);
		return mav;
	}

	/**
	 * update
	 * 
	 * @param sessionObject
	 * @param auctionId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "{auctionId}/update", method = RequestMethod.POST)
	public ModelAndView auctionUpdate(@PathVariable Long auctionId,
			AuctionForm form) throws IOException {
		log.debug("[LOG][form]" + form);

		Auction auction = new Auction();
		BeanUtils.copyProperties(form, auction);
		log.debug("[LOG][auction]" + auction);

		String fileName = null;
		if (StringUtils.isNotBlank(form.getAuctionLogoPathAction())) {
			CommonsMultipartFile file = form.getFile();
			fileName = file.getOriginalFilename();
			fileName = new Date().getTime()
					+ fileName.substring(fileName.indexOf("."));

			FileUtils.deleteQuietly(new File(Constant.UPLOAD_FOLDER_AUCTION
					+ form.getAuctionLogoPath()));

			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					Constant.UPLOAD_FOLDER_AUCTION + fileName));
			auction.setAuctionLogoPath(fileName);
		}

		auctionService.update(auction);

		ModelAndView mav = new ModelAndView("redirect:/manager/auction/list.do");
		return mav;
	}

	@RequestMapping(value = "{auctionId}/delete", method = RequestMethod.GET)
	public ModelAndView auctionDelete(@PathVariable Long auctionId,
			AuctionForm form) {

		auctionService.delete(auctionId);

		ModelAndView mav = new ModelAndView("redirect:/manager/auction/list.do");
		return mav;
	}
	

}
