package com.charitybuzz.web.manager.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.Constant;
import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Auction;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.dto.SubCategory;
import com.charitybuzz.service.AuctionService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;
import com.charitybuzz.service.SubCategoryService;
import com.charitybuzz.service.SubcategoryItemService;
import com.charitybuzz.web.form.ItemForm;

@Controller
@RequestMapping(value = "/manager")
@SessionAttributes(value = { "operator" })
public class ItemManager {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(SubCategoryManager.class);

	/**
	 * 商品
	 */
	@Resource
	private ItemService itemService;
	/**
	 * 第二級目錄
	 */
	@Resource
	private SubCategoryService subCategoryService;
	@Resource
	private SubcategoryItemService subcategoryItemService;
	@Resource
	private PictureService pictureService;
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
	 * 拿到列表 當商品開始拍賣，則不能刪除
	 * 
	 * @param form
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/auctionId/{auctionId}/item/list")
	public ModelAndView itemList(@PathVariable Long auctionId) {
		ModelAndView mav = new ModelAndView("manager/item/list");
		Pager<Item> items = itemService.findPagerByAuctionId(auctionId);
		mav.addObject("items", items);
		return mav;
	}

	/**
	 * 拿到add page
	 * 
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/auctionId/{auctionId}/item/add", method = RequestMethod.GET)
	public ModelAndView itemAddPage(@PathVariable Long auctionId) {
		ModelAndView mav = new ModelAndView("manager/item/add");
		List<SubCategory> subCategories = subCategoryService.findAll();
		mav.addObject("subCategories", subCategories);
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
	@RequestMapping(value = "/auctionId/{auctionId}/item/add", method = RequestMethod.POST)
	public ModelAndView itemAdd(@PathVariable Long auctionId, ItemForm form)
			throws IOException {
		ModelAndView mav = new ModelAndView("redirect:/manager/auctionId/"
				+ auctionId + "/item/list.do");

		log.debug("[LOG]ItemForm=" + form);
		Item it = new Item();
		BeanUtils.copyProperties(form, it);
		it.setAuctionId(auctionId);
		Long itemId = itemService.insert(it);

		subcategoryItemService.insert(itemId, form.getSubCategoryIds());

		this.pictures(itemId,form);

		return mav;
	}

	/**
	 * 拿到update page
	 * 
	 * @param sessionObject
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value = "/auctionId/{auctionId}/item/{itemId}/update", method = RequestMethod.GET)
	public ModelAndView itemUpdatePage(@PathVariable Long auctionId,
			@PathVariable Long itemId) {
		ModelAndView mav = new ModelAndView("manager/item/update");

		List<SubCategory> subCategories = subCategoryService.findAll();
		mav.addObject("subCategories", subCategories);
		Item item = itemService.findById(itemId);
		mav.addObject("item", item);

		/**
		 * 拍賣會
		 */
		List<Auction> auctions = auctionService.findAll();
		mav.addObject("auctions", auctions);
		for (Auction auction : auctions) {
			if (auction.getId() == item.getAuctionId()) {
				auction.setAuctionCheckedMark("checked");
			}
		}

		List<SubCategory> subCas = subCategoryService.findByItemd(itemId);
		for (SubCategory subCategory : subCategories) {

			for (SubCategory subCa : subCas) {
				if (subCategory.getId() == subCa.getId()) {
					subCategory.setItemCheckedMark("checked");
				}
			}
		}

		List<Picture> pictures = pictureService.findByItemId(itemId);
		item.setPictures(pictures);

		return mav;
	}

	/**
	 * update
	 * 
	 * @param sessionObject
	 * @param itemId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/auctionId/{auctionId}/item/{itemId}/update", method = RequestMethod.POST)
	public ModelAndView itemUpdate(@PathVariable Long auctionId,
			@PathVariable Long itemId,
			@ModelAttribute("itemForm") ItemForm form) throws IOException {

		ModelAndView mav = new ModelAndView("redirect:/manager/auctionId/"
				+ auctionId + "/item/list.do");

		log.debug("[LOG]ItemForm=" + form);
		this.pictures(itemId,form);
		Item it = new Item();
		BeanUtils.copyProperties(form, it);

		log.debug("[LOG]" + it.getId());

		itemService.update(it);

		subcategoryItemService.update(form.getId(), form.getSubCategoryIds());

		return mav;
	}

	@RequestMapping(value = "/auctionId/{auctionId}/item/{itemId}/delete", method = RequestMethod.GET)
	public ModelAndView itemDelete(@PathVariable Long auctionId,
			@PathVariable Long itemId) {
		itemService.delete(itemId);
		ModelAndView mav = new ModelAndView("redirect:/manager/auctionId/"
				+ auctionId + "/item/list.do");
		return mav;
	}

	private void pictures(Long itemId,ItemForm form) throws IOException {

		List<CommonsMultipartFile> files = form.getFiles();
		List<Integer> priorities = form.getPriorities();
		List<Long> picIds = form.getPicIds();
		List<String> cruds = form.getCruds();

		List<Picture> insertPictures = new ArrayList<Picture>();
		List<Picture> updatePictures = new ArrayList<Picture>();
		List<Long> deletePictures = new ArrayList<Long>();
		if (null != files && files.size() > 0) {
			for (int i = 0; i < files.size(); i++) {
				CommonsMultipartFile multipartFile = files.get(i);
				Integer priority = priorities.get(i);
				String crud = cruds.get(i);
				Long picId = picIds.get(i);

				if ("d".equals(crud)) {
					deletePictures.add(picId);
				}

				String fileName = multipartFile.getOriginalFilename();

				if (StringUtils.isNotBlank(fileName)) {
					fileName = new Date().getTime()
							+ fileName.substring(fileName.indexOf("."));
				}

				if ("u".equals(crud)) {

					if (StringUtils.isNotBlank(fileName)) {
						FileUtils.copyInputStreamToFile(multipartFile
								.getInputStream(), new File(
								Constant.UPLOAD_FOLDER_ITEM + fileName));
					} else {
						fileName = "";
					}
					updatePictures.add(new Picture(picId, itemId,
							priority, fileName));

				}
				if ("c".equals(crud)) {
					insertPictures.add(new Picture(itemId, priority,
							fileName));
					FileUtils.copyInputStreamToFile(multipartFile
							.getInputStream(), new File(
							Constant.UPLOAD_FOLDER_ITEM + fileName));
				}

			}
		}
		// 圖片處理
		pictureService.insert(insertPictures);
		pictureService.delete(deletePictures);
		pictureService.update(updatePictures);
	}
}
