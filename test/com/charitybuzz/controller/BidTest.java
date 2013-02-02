package com.charitybuzz.controller;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.charitybuzz.common.rule.MoneyRule;

@Transactional
public class BidTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());


	@Test
	public void bid() {
		// double currentBid = 6750;
		double currentBid = 511;

		// $7,250
		log.debug("[LOG][當前money]" + currentBid);
		log.debug("[LOG][下一個money]" + MoneyRule.nextIncrementPrice(currentBid));


	}

	/**
	 * @param currentBid
	 * @return
	 */
	public double getNextValue(double currentBid) {
		List<Double> nextValueLevel = Arrays.asList(new Double[] { 250d, 500d,
				1000d, 5000d, 10000d, 25000d, 50000d, 10000000d });
		List<Double> nextValueAdd = Arrays.asList(new Double[] { 25d, 50d,
				100d, 250d, 500d, 1000d, 2500d, 5000d });

		for (int i = 0; i < nextValueLevel.size(); i++) {
			if (currentBid < nextValueLevel.get(i)) {
				return currentBid + nextValueAdd.get(i);
			}
		}
		return 0d;
	}


}
