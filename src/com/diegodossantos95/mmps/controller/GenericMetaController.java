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

import com.diegodossantos95.mmps.dao.GenericMetaDAO;
import com.diegodossantos95.mmps.exception.ResourceNotFoundException;
import com.diegodossantos95.mmps.model.GenericMeta;

@Controller
@RequestMapping("/genericmeta")
public class GenericMetaController {

	@Autowired
	private GenericMetaDAO genericMetaDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<GenericMeta> findAll() {
		return genericMetaDAO.getAllGenericMeta();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody GenericMeta findById(@PathVariable long id) {
		GenericMeta object = genericMetaDAO.getGenericMetaById(id);
		if(object == null){
            throw new ResourceNotFoundException(); 
		}
		return object;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody GenericMeta create(@RequestBody GenericMeta processArea) {
		return genericMetaDAO.createGenericMeta(genericMeta);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		genericMetaDAO.deleteGenericMeta(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody GenericMeta update(@PathVariable long id, @RequestBody GenericMeta genericMeta) {
		return genericMetaDAO.updateGenericMeta(id, genericMeta);
	}
}
