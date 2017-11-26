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
public class GenericMetaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<GenericMeta> getAllGenericMeta(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<GenericMeta> criteria = cb.createQuery(GenericMeta.class);
		Collection<GenericMeta> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public GenericMeta getGenericMetaById(long id){
		GenericMeta genericMeta = em.find(GenericMeta.class, id);
		return genericMeta;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public GenericMeta createGenericMeta(GenericMeta genericMeta){
		em.persist(genericMeta);
		return genericMeta;
	}
	
	@Transactional
	public void deleteGenericMeta(long id) {
		GenericMeta genericMeta = getGenericMetaById(id);

		if (genericMeta != null) {
			em.remove(genericMeta);
		}
	}
	
	@Transactional
	public GenericMeta updateGenericMeta(long id, GenericMeta newGenericMeta){
		GenericMeta genericMeta = getGenericMetaById(id);
		
		genericMeta.setName(newGenericMeta.getName());
		genericMeta.setDescription(newGenericMeta.getDescription());
		genericMeta.setInitials(newGenericMeta.getInitials());
				
		em.merge(genericMeta);
		return genericMeta;
	}
}
