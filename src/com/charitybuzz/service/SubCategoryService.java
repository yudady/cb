package com.charitybuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.charitybuzz.domain.SubCategory;
@Service
public class SubCategoryService {

	public List<SubCategory> findItensByCategoryId(Long categoryId) {
		List<SubCategory> subCategories = new ArrayList<SubCategory>();
		if(categoryId == 1L){
			subCategories.add(new SubCategory(1L, 1L, "subCategories1", "subCategories1"));
			subCategories.add(new SubCategory(2L, 1L, "subCategories1", "subCategories1"));
			subCategories.add(new SubCategory(3L, 1L, "subCategories1", "subCategories1"));
			subCategories.add(new SubCategory(4L, 1L, "subCategories1", "subCategories1"));
			subCategories.add(new SubCategory(5L, 1L, "subCategories1", "subCategories1"));
		}
		return subCategories;
	}

}
