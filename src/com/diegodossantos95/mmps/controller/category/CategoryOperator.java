package com.diegodossantos95.mmps.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelOperator;
import com.diegodossantos95.mmps.model.Category;
import com.diegodossantos95.mmps.repository.CategoryRepository;

@Component
public class CategoryOperator extends AbstractModelOperator<Category, CategoryRepository> {
	@Autowired
	public CategoryOperator(CategoryRepository repository) {
		super(repository);
	}

	@Override
	protected Category updateFields(Category existingInstance, Category updatedInstance) {
		existingInstance.setName(updatedInstance.getName());

		return existingInstance;
	}
}
