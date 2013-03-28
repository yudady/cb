package com.charitybuzz.web.cb;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.cache.SidebarService;
import com.charitybuzz.common.Constant;
import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Bidlog;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.dto.Picture;
import com.charitybuzz.service.BidlogService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.service.PictureService;
/**
 * 首頁tabs
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/tabs")
public class TabsController {
	/** logger. */
	private Logger log = LoggerFactory.getLogger(TabsController.class);

	@Resource
	private SidebarService sidebarService;

	/**
	 * 全部商品
	 */
	@Resource
	private ItemService itemService;
	/**
	 * 商品圖片
	 */
	@Resource
	private PictureService pictureService;

	@Resource
	private BidlogService bidlogService;

	/**
	 * 最接近結標日的商品列表
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/closingNext", method = RequestMethod.GET)
	public ModelAndView closingNext(HttpSession session) {
		ModelAndView mav = new ModelAndView("indexTabs/closeNext4Tab");

		List<Item> items = itemService.findClosingNext(Constant.INDEX_TABS_ITEMS_SIZE);
		for (Item item : items) {
			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		mav.addObject("items", items);
		return mav;

	}

	/**
	 * 差價最大的商品列表
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/hotDeals", method = RequestMethod.GET)
	public ModelAndView hotDeals(HttpSession session) {
		ModelAndView mav = new ModelAndView("indexTabs/hotDeals4Tab");

		List<Item> items = itemService.findByHotDeals(Constant.INDEX_TABS_ITEMS_SIZE);
		for (Item item : items) {
			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		mav.addObject("items", items);
		return mav;

	}

	/**
	 * 最受歡迎的商品列表
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/popular", method = RequestMethod.GET)
	public ModelAndView popular(HttpSession session) {
		ModelAndView mav = new ModelAndView("indexTabs/popular4Tab");

		List<Item> items = itemService.findPopular(Constant.INDEX_TABS_ITEMS_SIZE);
		for (Item item : items) {
			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
			
			List<Bidlog> bidlogs = bidlogService.findByItemId(itemId);
			item.setBidlogs(bidlogs);
		}
		mav.addObject("items", items);
		return mav;

	}

	/**
	 * 新進商品的商品列表
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/recentAdd", method = RequestMethod.GET)
	public ModelAndView recentAdd(HttpSession session) {
		ModelAndView mav = new ModelAndView("indexTabs/recentAdd4Tab");

		List<Item> items = itemService.findRecentAdd(Constant.INDEX_TABS_ITEMS_SIZE);
		for (Item item : items) {
			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		mav.addObject("items", items);
		return mav;

	}

	@RequestMapping(value = "/{tabIndex}/list", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable int tabIndex) {
		
		log.debug("[LOG][tabIndex]");
		ModelAndView mav = new ModelAndView("cb/itemsPager");
		mav.addObject("tabIndex", tabIndex);
		
		
		List<Category> categories = sidebarService.getCategories();
		mav.addObject("categories", categories);
		/**
		 * 全部商品
		 */
		Pager<Item> pager = null;
		switch (tabIndex) {
		case 1:
			pager = itemService.findPagerByClosingNext();
			break;
		case 2:
			pager = itemService.findPagerByHotDeals();
			break;
		case 3:
			pager = itemService.findPagerByPopular();
			break;
		case 4:
			pager = itemService.findPagerByRecentAdd();
			break;
		default:
			break;
		}
		List<Item> items = pager.getDatas();
		mav.addObject("pager", pager);

		for (Item item : items) {

			Long itemId = item.getId();
			List<Picture> pictures = pictureService.findByItemId(itemId);
			item.setPictures(pictures);
		}
		return mav;
	}

}
