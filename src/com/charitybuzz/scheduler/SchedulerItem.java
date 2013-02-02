package com.charitybuzz.scheduler;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.domain.Item;
import com.charitybuzz.service.ItemService;

public class SchedulerItem {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(this.getClass());

	private boolean openScheduler;
	
	private ItemService itemService;
	
	public void setOpenScheduler(boolean openScheduler) {
		this.openScheduler = openScheduler;
	}
	
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}


	public void endBidding() {
		if(!openScheduler){
			return;
		}
		log.debug("[LOG]endBidding open");
		List<Item> items = itemService.findEndBiddingByLotclose();
		for (Item item : items) {
			log.debug("[LOG][item]" + item);
			// 把商品更新為結標
			itemService.closingBidding(item.getId());

			// 通知得標者 : winning bidder
//			ItemDetail itemDetail = itemDetailService
//					.findByItemId(item.getId());
//
//			log.debug("[LOG]" + itemDetail.getWinningBidderId());
//			Bidder bidder = bidderService.findById(itemDetail
//					.getWinningBidderId());
//
//			log.debug("[LOG][winning bidder]" + bidder);
		}
	}

}
