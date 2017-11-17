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
public class ProcessAreaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<ProcessArea> getAllProcessArea(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ProcessArea> criteria = cb.createQuery(ProcessArea.class);
		Collection<ProcessArea> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public ProcessArea getProcessAreaById(long id){
		ProcessArea processArea = em.find(ProcessArea.class, id);
		return processArea;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public ProcessArea createProcessArea(ProcessArea processArea){
		em.persist(processArea);
		return processArea;
	}
	
	@Transactional
	public void deleteProcessArea(long id) {
		ProcessArea processArea = getProcessAreaById(id);

		if (processArea != null) {
			em.remove(processArea);
		}
	}
	
	@Transactional
	public ProcessArea updateProcessArea(long id, ProcessArea newProcessArea){
		ProcessArea processArea = getProcessAreaById(id);
		
		processArea.setName(newProcessArea.getName());
		processArea.setDescription(newProcessArea.getDescription());
		processArea.setInitials(newProcessArea.getInitials());
		processArea.setCategory(newProcessArea.getCategory());
		
		em.merge(processArea);
		return processArea;
	}
}
