package com.diegodossantos95.mmps.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diegodossantos95.mmps.model.SpecificPractice;

@Repository
public class SpecificPracticeDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<SpecificPractice> getAllSpecificPractice(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<SpecificPractice> criteria = cb.createQuery(SpecificPractice.class);
		Collection<SpecificPractice> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public SpecificPractice getSpecificPracticeById(long id){
		SpecificPractice SpecificPractice = em.find(SpecificPractice.class, id);
		return SpecificPractice;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public SpecificPractice createSpecificPractice(SpecificPractice SpecificPractice){
		em.persist(SpecificPractice);
		return SpecificPractice;
	}
	
	@Transactional
	public void deleteSpecificPractice(long id) {
		SpecificPractice SpecificPractice = getSpecificPracticeById(id);

		if (SpecificPractice != null) {
			em.remove(SpecificPractice);
		}
	}
	
	@Transactional
	public SpecificPractice updateSpecificPractice(long id, SpecificPractice newSpecificPractice){
		SpecificPractice SpecificPractice = getSpecificPracticeById(id);
		
		SpecificPractice.setName(newSpecificPractice.getName());
		SpecificPractice.setDescription(newSpecificPractice.getDescription());
		SpecificPractice.setInitials(newSpecificPractice.getInitials());
		
		em.merge(SpecificPractice);
		return SpecificPractice;
	}
}
