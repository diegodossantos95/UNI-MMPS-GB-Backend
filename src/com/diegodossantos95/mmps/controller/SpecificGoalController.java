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

import com.diegodossantos95.mmps.dao.SpecificGoalDAO;
import com.diegodossantos95.mmps.exception.ResourceNotFoundException;
import com.diegodossantos95.mmps.model.SpecificGoal;

@Controller
@RequestMapping("/specificGoal")
public class SpecificGoalController {

	@Autowired
	private SpecificGoalDAO specificGoalDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<SpecificGoal> findAll() {
		return specificGoalDao.getAllSpecificGoal();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody SpecificGoal findById(@PathVariable long id) {
		SpecificGoal object = specificGoalDao.getSpecificGoalById(id);
		if(object == null){
            throw new ResourceNotFoundException(); 
		}
		return object;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody SpecificGoal create(@RequestBody SpecificGoal SpecificGoal) {
		return specificGoalDao.createSpecificGoal(SpecificGoal);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		specificGoalDao.deleteSpecificGoal(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody SpecificGoal update(@PathVariable long id, @RequestBody SpecificGoal SpecificGoal) {
		return specificGoalDao.updateSpecificGoal(id, SpecificGoal);
	}
}
