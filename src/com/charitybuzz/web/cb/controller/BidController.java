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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.charitybuzz.common.rule.MoneyRule;
import com.charitybuzz.dto.Bidder;
import com.charitybuzz.dto.Bidlog;
import com.charitybuzz.dto.Item;
import com.charitybuzz.service.BidlogService;
import com.charitybuzz.service.ItemService;
import com.charitybuzz.web.cb.form.BidForm;

@Controller
@RequestMapping("/bid")
@SessionAttributes({ "bidder" })
public class BidController {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(BidController.class);

	@Resource
	private ItemService itemService;
	@Resource
	private BidlogService bidlogService;

	@RequestMapping(value = "/{itemId}/index", method = RequestMethod.GET)
	public String bid(@ModelAttribute("bidder") Bidder bidder, BidForm form) {

		Long winningBidderId = bidder.getId();
		Item item = itemService.findById(form.getItemId());
		log.debug("[LOG][bid]" + winningBidderId);
		log.debug("[LOG][bid]" + item);
		if ((form.getBiddingBidNowPrice()) >= item.getIncrementPrice()) {
			// ok
			Double nextIncrementPrice = MoneyRule.nextIncrementPrice(form
					.getBiddingBidNowPrice());
			item.setIncrementPrice(nextIncrementPrice);
			item.setWinningBidderId(winningBidderId);

			itemService.update(item);
			// add log
			bidlogService.insert(new Bidlog(bidder.getId(), item.getId(), form
					.getBiddingBidNowPrice()));
		}

		return "redirect:" + form.getBiddingBidUrl();
	}

	@ExceptionHandler({ HttpSessionRequiredException.class })
	public ModelAndView noSessionObject(Exception ex) {
		return new ModelAndView("redirect:/index.do");
	}
}
