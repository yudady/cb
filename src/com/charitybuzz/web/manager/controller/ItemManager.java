package com.charitybuzz.web.manager.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Operator;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.dto.SubCategory;
import com.charitybuzz.operate.SidebarService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;
import com.charitybuzz.service.SubCategoryService;
import com.charitybuzz.service.SubcategoryItemService;
import com.charitybuzz.web.manager.form.ItemForm;

@Controller
@RequestMapping(value = "/manager/item")
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
	@Resource
	private SidebarService sidebarService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	/**
	 * 拿到列表
	 * 
	 * @param form
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView itemList(ItemForm form) {
		ModelAndView mav = new ModelAndView("manager/item/list");
		List<Item> items = itemService.findAll();
		mav.addObject("items", items);
		return mav;
	}

	/**
	 * 拿到add page
	 * 
	 * @param sessionObject
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView itemAddPage() {
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
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView itemAdd(ItemForm form, BindingResult result,HttpSession session)
			throws IOException {

		// if (result.hasErrors()) {
		// throw new RuntimeException("驗證錯誤");
		// }

		log.debug("[LOG]ItemForm=" + form);
		Operator operator = (Operator)session.getAttribute("operator");
		Long itemId = itemService.insert(new Item(form.getTitle(), form
				.getCurrentBid(), form.getStartDate(), form.getCloseDate(),
				form.getEstimatedValue(), form.getIncrementPrice(), form
						.getStatus(), form.getLotDetails(), form
						.getLegalTerms(), form.getShipping(), form
						.getWinningBidderId(),operator.getId()));

		subcategoryItemService.insert(itemId, form.getSubCategoryIds());
		sidebarService.setCategories(null);

		form.setItemIdForm(itemId);
		this.pictures(form);

		ModelAndView mav = new ModelAndView("redirect:/manager/item/list.do");
		return mav;
	}

	/**
	 * 拿到update page
	 * 
	 * @param sessionObject
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value = "{itemId}/update", method = RequestMethod.GET)
	public ModelAndView itemUpdatePage(@PathVariable Long itemId) {
		ModelAndView mav = new ModelAndView("manager/item/update");
		List<SubCategory> subCategories = subCategoryService.findAll();
		mav.addObject("subCategories", subCategories);
		Item item = itemService.findById(itemId);
		mav.addObject("item", item);

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
	@RequestMapping(value = "{itemId}/update", method = RequestMethod.POST)
	public ModelAndView itemUpdate(@ModelAttribute("itemForm") ItemForm form,
			BindingResult result, HttpServletRequest request)
			throws IOException {
		// if (result.hasErrors()) {
		// throw new RuntimeException("驗證錯誤");
		// }
		log.debug("[LOG]ItemForm=" + form);
		this.pictures(form);

		itemService.update(new Item(form.getItemIdForm(), form.getTitle(), form
				.getCurrentBid(), form.getStartDate(), form.getCloseDate(),
				form.getEstimatedValue(), form.getIncrementPrice(), form
						.getStatus(), form.getLotDetails(), form
						.getLegalTerms(), form.getShipping(), form
						.getWinningBidderId()));

		subcategoryItemService.update(form.getItemIdForm(),
				form.getSubCategoryIds());
		sidebarService.setCategories(null);

		ModelAndView mav = new ModelAndView("redirect:/manager/item/list.do");
		return mav;
	}

	@RequestMapping(value = "{itemId}/delete", method = RequestMethod.GET)
	public ModelAndView itemDelete(@PathVariable Long itemId) {
		itemService.delete(itemId);
		ModelAndView mav = new ModelAndView("redirect:/manager/item/list.do");
		return mav;
	}

	private void pictures(ItemForm form) throws IOException {

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

				if(StringUtils.isNotBlank(fileName)){
					fileName = new Date().getTime()
							+ fileName.substring(fileName.indexOf("."));
				}

				if ("u".equals(crud)) {

					if (StringUtils.isNotBlank(fileName)) {
						FileUtils.copyInputStreamToFile(multipartFile
								.getInputStream(), new File(Constant.UPLOAD_FOLDER
								+ fileName));
					} else {
						fileName = "";
					}
					updatePictures.add(new Picture(picId, form
							.getItemIdForm(), priority, fileName));

				}
				if ("c".equals(crud)) {
					insertPictures.add(new Picture(form.getItemIdForm(),
							priority, fileName));
					FileUtils.copyInputStreamToFile(multipartFile
							.getInputStream(),
							new File(Constant.UPLOAD_FOLDER + fileName));
				}

			}
		}
		// 圖片處理
		pictureService.insert(insertPictures);
		pictureService.delete(deletePictures);
		pictureService.update(updatePictures);
	}
}
