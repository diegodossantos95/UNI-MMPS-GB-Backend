package com.diegodossantos95.mmps.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diegodossantos95.mmps.model.ProcessArea;

@Repository
public class EspecificPraticeDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<EspecificPratice> getAllEspecificPratice(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EspecificPratice> criteria = cb.createQuery(EspecificPratice.class);
		Collection<EspecificPratice> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public EspecificPratice getEspecificPraticeById(long id){
		EspecificPratice especificPratice = em.find(EspecificPratice.class, id);
		return especificPratice;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public EspecificPratice createEspecificPratice(EspecificPratice especificPratice){
		em.persist(especificPratice);
		return especificPratice;
	}
	
	@Transactional
	public void deleteEspecificPratice(long id) {
		EspecificPratice especificPratice = getEspecificPraticeById(id);

		if (especificPratice != null) {
			em.remove(especificPratice);
		}
	}
	
	@Transactional
	public EspecificPratice updateEspecificPratice(long id, EspecificPratice newEspecificPratice){
		EspecificPratice especificPratice = getEspecificPraticeById(id);
		
		especificPratice.setName(newEspecificPratice.getName());
		especificPratice.setDescription(newEspecificPratice.getDescription());
		especificPratice.setInitials(newEspecificPratice.getInitials());
		
		em.merge(especificPratice);
		return especificPratice;
	}
}
