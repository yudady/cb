package com.charitybuzz.web.manager.dwr;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.dto.Bidder;
import com.charitybuzz.service.WatchingService;
import com.charitybuzz.web.cb.controller.WatchController;

@Controller
@RemoteProxy(name = "watch")
@SessionAttributes({ "bidder" })
public class TestController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(WatchController.class);

	@Resource
	private WatchingService watchingService;

	@RemoteMethod
	public String item(Long itemId, String watchStatus) {
		HttpSession session = WebContextFactory.get().getSession();
		Bidder bidder = (Bidder) session.getAttribute("bidder");

		log.debug("[LOG][watch][itemId]=" + itemId + "[watchStatus]="
				+ watchStatus + "[bidder]=" + bidder);

		if ("1".equals(watchStatus)) {
			watchingService.addBidderWaching(bidder.getId(), itemId);
		} else {
			watchingService.delBidderWaching(bidder.getId(), itemId);
		}
		return "watch itemId=" + itemId + " bidderId=" + bidder.getId()
				+ " watchStatus(0:false,1:true)=" + watchStatus;
	}

	@ExceptionHandler({ HttpSessionRequiredException.class })
	public ModelAndView noSessionObject(Exception ex) {
		return new ModelAndView("redirect:/index.do");
	}
}
