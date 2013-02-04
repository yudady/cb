package com.charitybuzz.web.cb.dwr;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.charitybuzz.dto.Bidder;
import com.charitybuzz.service.WatchingService;

@Controller
@RemoteProxy(name = "watch")
public class WatchController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(WatchController.class);

	@Resource
	private WatchingService watchingService;

	@RemoteMethod
	public String item(Long itemId, String watchStatus) {
		log.debug("[LOG]WatchController");
		HttpSession session = WebContextFactory.get().getSession();
		Bidder bidder = null;
		System.out.println("[LOG]"+itemId);
		System.out.println("[LOG]"+watchStatus);
//		log.debug("[watch][itemId]=" + itemId + "[watchStatus]=" + watchStatus
//				+ "[bidder]=" + bidder);
//		
//		
//		if ("1".equals(watchStatus)) {
//			watchingService.addBidderWaching(bidder.getId(), itemId);
//		} else {
//			watchingService.delBidderWaching(bidder.getId(), itemId);
//		}
//		return "watch itemId=" + itemId + " bidderId=" + bidder.getId()
//				+ " watchStatus=" + watchStatus;
		return "111111111111111";
	}

}
