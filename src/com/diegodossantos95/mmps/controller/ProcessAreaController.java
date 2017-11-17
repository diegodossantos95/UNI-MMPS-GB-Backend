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

import com.diegodossantos95.mmps.dao.ProcessAreaDAO;
import com.diegodossantos95.mmps.exception.ResourceNotFoundException;
import com.diegodossantos95.mmps.model.ProcessArea;

@Controller
@RequestMapping("/process-area")
public class ProcessAreaController {

	@Autowired
	private ProcessAreaDAO processAreaDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<ProcessArea> findAll() {
		return processAreaDao.getAllProcessArea();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ProcessArea findById(@PathVariable long id) {
		ProcessArea object = processAreaDao.getProcessAreaById(id);
		if(object == null){
            throw new ResourceNotFoundException(); 
		}
		return object;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ProcessArea create(@RequestBody ProcessArea processArea) {
		return processAreaDao.createProcessArea(processArea);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		processAreaDao.deleteProcessArea(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ProcessArea update(@PathVariable long id, @RequestBody ProcessArea processArea) {
		return processAreaDao.updateProcessArea(id, processArea);
	}
}
