package com.charitybuzz.web.cb;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.cache.SidebarService;
import com.charitybuzz.dto.Auction;
import com.charitybuzz.dto.Bidder;
import com.charitybuzz.dto.Bidlog;
import com.charitybuzz.dto.Category;
import com.charitybuzz.dto.Item;
import com.charitybuzz.service.AuctionService;
import com.charitybuzz.service.BidderService;
import com.charitybuzz.service.BidlogService;
import com.charitybuzz.service.ItemService;

@Controller
@RequestMapping("/item")
/**
 * 歷史紀錄
 * @author Administrator
 *
 */
public class BidlogController {
	/** logger. */
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	/**
	 * menu
	 */
	@Resource
	private SidebarService sidebarService;
	
	/**
	 * 全部商品
	 */
	@Resource
	private ItemService itemService;
	
	/**
	 * 商品log
	 */
	@Resource
	private BidlogService bidlogService;
	
	/**
	 * 拍賣會
	 */
	@Resource
	private AuctionService auctionService;
	
	/**
	 * 投標者
	 */
	@Resource
	private BidderService bidderService;
	
	/**
	 * 歷史紀錄
	 * @param bidder
	 * @param form
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value = "/{itemId}/bidlog", method = RequestMethod.GET)
	public ModelAndView bidderlog(@PathVariable Long itemId) {
		log.debug("[LOG][itemId][bidlog]=" + itemId);

		ModelAndView mav = new ModelAndView("cb/bidlog");
		
		/**
		 * 目錄
		 */
		List<Category> categories = sidebarService.getCategories();
		mav.addObject("categories", categories);
		
		log.debug("[itemId]=" + itemId);
		Item item = itemService.findById(itemId);
		mav.addObject("item", item);
		
		
		Auction auc = auctionService.findById(item.getAuctionId());
		mav.addObject("auc", auc);
		
		
		Bidder winner = bidderService.findById(item.getWinningBidderId());
		mav.addObject("winner", winner);
		
		List<Bidlog> bidlogs = bidlogService.findByItemId(itemId);
		System.out.println("[LOG]" + bidlogs);
		log.debug("[LOG]" + bidlogs.size());
		mav.addObject("bidlogs", bidlogs);
		return mav;
	}

}
