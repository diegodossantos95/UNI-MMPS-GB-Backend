package com.diegodossantos95.mmps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegodossantos95.mmps.controller.category.CategoryOperator;
import com.diegodossantos95.mmps.controller.category.CategoryQuery;
import com.diegodossantos95.mmps.model.Category;

@RestController
@RequestMapping("/category")
public class CategoryServlet extends AbstractBaseRestService<Category, CategoryOperator, CategoryQuery> {

	@Autowired
	public CategoryServlet(CategoryOperator operator, CategoryQuery query) {
		super(operator, query);
	}
}
