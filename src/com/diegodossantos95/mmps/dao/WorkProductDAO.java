package com.diegodossantos95.mmps.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diegodossantos95.mmps.model.WorkProduct;

@Repository
public class WorkProductDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<WorkProduct> getAllWorkProduct(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<WorkProduct> criteria = cb.createQuery(WorkProduct.class);
		Collection<WorkProduct> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public WorkProduct getWorkProductById(long id){
		WorkProduct WorkProduct = em.find(WorkProduct.class, id);
		return WorkProduct;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public WorkProduct createWorkProduct(WorkProduct WorkProduct){
		em.persist(WorkProduct);
		return WorkProduct;
	}
	
	@Transactional
	public void deleteWorkProduct(long id) {
		WorkProduct WorkProduct = getWorkProductById(id);

		if (WorkProduct != null) {
			em.remove(WorkProduct);
		}
	}
	
	@Transactional
	public WorkProduct updateWorkProduct(long id, WorkProduct newWorkProduct){
		WorkProduct WorkProduct = getWorkProductById(id);
		
		WorkProduct.setName(newWorkProduct.getName());
		WorkProduct.setLink(newWorkProduct.getLink());
		WorkProduct.setSpecificPractices(newWorkProduct.getSpecificPractices());
		
		em.merge(WorkProduct);
		return WorkProduct;
	}
}
