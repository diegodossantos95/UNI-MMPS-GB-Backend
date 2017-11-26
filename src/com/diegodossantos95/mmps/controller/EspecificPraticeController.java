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

import com.diegodossantos95.mmps.dao.EspecificPraticeDAO;
import com.diegodossantos95.mmps.exception.ResourceNotFoundException;
import com.diegodossantos95.mmps.model.EspecificPratice;

@Controller
@RequestMapping("/especific-pratice")
public class EspecificPraticeController {

	@Autowired
	private EspecificPraticeDAO especificPraticeDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<EspecificPratice> findAll() {
		return especificPraticeDao.getAllEspecificPratice();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody EspecificPratice findById(@PathVariable long id) {
		EspecificPratice object = especificPraticeDao.getEspecificPraticeById(id);
		if(object == null){
            throw new ResourceNotFoundException(); 
		}
		return object;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody EspecificPratice create(@RequestBody EspecificPratice especificPratice) {
		return especificPraticeDao.createEspecificPratice(especificPratice);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		especificPraticeDao.deleteProcessArea(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody EspecificPratice update(@PathVariable long id, @RequestBody EspecificPratice especificPratice) {
		return especificPraticeDao.updateEspecificPratice(id, especificPratice);
	}
}
