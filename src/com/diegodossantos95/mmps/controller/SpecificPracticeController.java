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

import com.diegodossantos95.mmps.dao.SpecificPracticeDAO;
import com.diegodossantos95.mmps.exception.ResourceNotFoundException;
import com.diegodossantos95.mmps.model.SpecificPractice;

@Controller
@RequestMapping("/specificPractice")
public class SpecificPracticeController {

	@Autowired
	private SpecificPracticeDAO SpecificPracticeDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<SpecificPractice> findAll() {
		return SpecificPracticeDao.getAllSpecificPractice();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody SpecificPractice findById(@PathVariable long id) {
		SpecificPractice object = SpecificPracticeDao.getSpecificPracticeById(id);
		if(object == null){
            throw new ResourceNotFoundException(); 
		}
		return object;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody SpecificPractice create(@RequestBody SpecificPractice SpecificPractice) {
		return SpecificPracticeDao.createSpecificPractice(SpecificPractice);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		SpecificPracticeDao.deleteSpecificPractice(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody SpecificPractice update(@PathVariable long id, @RequestBody SpecificPractice SpecificPractice) {
		return SpecificPracticeDao.updateSpecificPractice(id, SpecificPractice);
	}
}
