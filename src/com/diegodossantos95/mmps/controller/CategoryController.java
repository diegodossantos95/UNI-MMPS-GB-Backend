package com.diegodossantos95.mmps.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.diegodossantos95.mmps.dao.CategoryDAO;
import com.diegodossantos95.mmps.model.Category;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Category> findAll() {
		return categoryDao.getAllCategory();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Category findById(@PathVariable long id) {
		return categoryDao.getCategoryById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Category create(@RequestBody Category category) {
		return categoryDao.createCategory(category);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		categoryDao.deleteCategory(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Category setOccupied(@PathVariable long id, @RequestBody Category category) {
		return categoryDao.updateCategory(id, category);
	}
}
