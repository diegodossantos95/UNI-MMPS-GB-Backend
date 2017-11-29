package com.diegodossantos95.mmps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.diegodossantos95.mmps.model.AbstractModel;
import com.diegodossantos95.mmps.repository.AbstractModelRepository;

@Controller
@Transactional
public abstract class AbstractModelOperator<T extends AbstractModel, R extends AbstractModelRepository<T>> {

	protected R repository;

	public AbstractModelOperator(R repository) {
		this.repository = repository;
	}

	public R getRepository() {
		return repository;
	}

	protected T beforeCreate(T instance) {
		return instance;
	}

	public T create(T instance) {

		loadReferences(instance);

		instance = validate(instance);

		instance = beforeCreate(instance);
		
		instance = repository.save(instance);

		instance = afterCreate(instance);

		return instance;
	}

	/**
	 * @param instance
	 */

	protected void loadReferences(T instance) {
	}

	protected T afterCreate(T instance) {
		return instance;
	}

	protected T validate(T instance) {
		return instance;

	}

	protected void beforeUpdate(T existingInstance, T updatedInstance) {
	}

	public T update(Long id, T updatedInstance) {
		T existingInstance = repository.findOne(id);

		loadReferences(updatedInstance);

		beforeUpdate(existingInstance, updatedInstance);

		existingInstance = updateFields(existingInstance, updatedInstance);

		existingInstance = validate(existingInstance);
		
		existingInstance = repository.save(existingInstance);

		existingInstance = afterUpdate(existingInstance);

		return existingInstance;
	}

	public void afterRemoveAssociations(T instance) {
		afterUpdate(instance);
	}

	protected abstract T updateFields(T existingInstance, T updatedInstance);

	protected T afterUpdate(T instance) {
		return instance;
	}

	protected void beforeDelete(T instance) {
		removeReferences(instance);
	}

	protected void removeReferences(T instance) {
	}

	public T delete(Long id) {
		T instance = repository.findOne(id);
		return delete(instance);
	}

	public T delete(T instance) {

		beforeDelete(instance);

		repository.delete(instance);

		afterDelete(instance);

		return instance;
	}

	public void checkDeletePermission(T instance) {
	}

	protected void afterDelete(T instance) {
	}

	protected void updateReferences(T deInstance, T paraInstance) {
	}
}