package com.diegodossantos95.mmps.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelQuery;
import com.diegodossantos95.mmps.model.Category;
import com.diegodossantos95.mmps.repository.CategoryRepository;

@Component
public class CategoryQuery extends AbstractModelQuery<Category, CategoryRepository> {

	@Autowired
	public CategoryQuery(CategoryRepository repository) {
		super(repository);
	}
}
