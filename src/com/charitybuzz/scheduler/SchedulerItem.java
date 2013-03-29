package com.charitybuzz.scheduler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.context.ConnectionContext;
import com.charitybuzz.dto.Bidder;
import com.charitybuzz.dto.Item;
import com.charitybuzz.service.BidderService;
import com.charitybuzz.service.ItemService;

/**
 * 結標，定時調度器
 * 
 * @author Administrator
 * 
 */
public class SchedulerItem {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	 * 是否開啟，定時調度器
	 */
	private boolean openScheduler;

	private ItemService itemService;

	private BidderService bidderService;

	public void setOpenScheduler(boolean openScheduler) {
		this.openScheduler = openScheduler;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public void setBidderService(BidderService bidderService) {
		this.bidderService = bidderService;
	}

	public void endBidding() throws SQLException {
		if (!openScheduler) {
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		log.debug("[LOG][Time]" + sdf.format(new Date()));
		List<Item> items = itemService.findEndBiddingByCloseDate();
		if (items.size() == 0) {
			return;
		}
		log.debug("[LOG][item]" + items.size());
		try {
			for (Item item : items) {
				log.debug("[LOG][item]" + item);
				// 把商品更新為結標
				itemService.updateClosingBidding(item.getId());

				// 通知得標者 : winning bidder
				Bidder bidder = bidderService.findById(item
						.getWinningBidderId());

				log.debug("[LOG][winning bidder]" + bidder);
				// TODO email to winning
			}
			ConnectionContext.commitWriteConnection();
		} finally {
			ConnectionContext.removeWriteConnection();
		}
	}

}
