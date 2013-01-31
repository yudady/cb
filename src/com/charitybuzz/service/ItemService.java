package com.charitybuzz.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.charitybuzz.domain.Item;
public class ItemService {

	public List<Item> findBySubCategoryId(Long id) {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item(1L, "title1", 100d, new Date(), new Date(), 3000d, 200d, 1, "lotDetails", "legalTerms", "shipping", 1L));
		items.add(new Item(2L, "title2", 100d, new Date(), new Date(), 3000d, 200d, 1, "lotDetails", "legalTerms", "shipping", 1L));
		items.add(new Item(3L, "title3", 100d, new Date(), new Date(), 3000d, 200d, 1, "lotDetails", "legalTerms", "shipping", 1L));
		return items;
	}

}
