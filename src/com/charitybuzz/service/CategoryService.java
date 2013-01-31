package com.charitybuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.charitybuzz.domain.Category;
@Service
public class CategoryService {

	public List<Category> findAll() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category(1L, "11111"));
		categories.add(new Category(2L, "22222"));
		categories.add(new Category(1L, "33333"));
		categories.add(new Category(1L, "44444"));
		categories.add(new Category(1L, "55555"));
		
		return categories;
	}

}
