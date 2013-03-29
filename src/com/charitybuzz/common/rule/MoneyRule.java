package com.charitybuzz.common.rule;

import java.util.Arrays;
import java.util.List;

/**
 * 計算下一次bidder，要多少錢
 * 
 * @author Administrator
 * 
 */
public class MoneyRule {
	/**
	 * @param currentBid
	 * @return
	 */
	public static Double nextIncrementPrice(double currentBid) {
		if (currentBid <= 0) {
			return null;
		}
		List<Double> nextValueLevel = Arrays.asList(new Double[] { 250d, 500d,
				1000d, 5000d, 10000d, 25000d, 50000d, 10000000d });
		List<Double> nextValueAdd = Arrays.asList(new Double[] { 25d, 50d,
				100d, 250d, 500d, 1000d, 2500d, 5000d });

		for (int i = 0; i < nextValueLevel.size(); i++) {
			if (currentBid < nextValueLevel.get(i)) {
				return currentBid + nextValueAdd.get(i);
			}
		}
		return null;
	}
}
