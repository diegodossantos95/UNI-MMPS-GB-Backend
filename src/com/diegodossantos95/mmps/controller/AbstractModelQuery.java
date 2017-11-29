package com.diegodossantos95.mmps.controller;

import java.util.List;

import com.diegodossantos95.mmps.exception.ResourceNotFoundException;
import com.diegodossantos95.mmps.model.AbstractModel;
import com.diegodossantos95.mmps.repository.AbstractModelRepository;

public class AbstractModelQuery<T extends AbstractModel, R extends AbstractModelRepository<T>> {
	
	protected R repository;

	public AbstractModelQuery(R repository) {
        this.repository = repository;
    }

	public List<T> findAll() {
		return repository.findAll();
	}

	public T findOne(Long id) {
		T instance = repository.findOne(id);
		checkIfNullThrowNotFound(instance);
		return instance;
	}
	
	public R getRepository() {
		return repository;
	}

	protected void checkIfNullThrowNotFound(T instance) {
		if (instance == null) {
			throw new ResourceNotFoundException();
		}
	}
}