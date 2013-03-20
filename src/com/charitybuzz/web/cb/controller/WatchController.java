package com.charitybuzz.web.cb.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.dto.Bidder;
import com.charitybuzz.service.WatchingService;
import com.charitybuzz.web.form.WatchForm;

@Controller
@SessionAttributes({ "bidder" })
@RequestMapping("/watch")
public class WatchController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(WatchController.class);

	@Resource
	private WatchingService watchingService;

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public @ResponseBody
	String item(WatchForm form, @ModelAttribute("bidder") Bidder bidder) {

		Long itemId = form.getItemId();
		String watchStatus = form.getWatchStatus();

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
		return new ModelAndView("redirect:/login.do");
	}
}
