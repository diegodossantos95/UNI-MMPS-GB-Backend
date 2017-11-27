package com.diegodossantos95.mmps.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diegodossantos95.mmps.model.Category;

@Repository
public class CategoryDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<Category> getAllCategory(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Category> criteria = cb.createQuery(Category.class);
		Collection<Category> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public Category getCategoryById(long id){
		Category category = em.find(Category.class, id);
		return category;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public Category createCategory(Category category){
		em.persist(category);
		return category;
	}
	
	@Transactional
	public void deleteCategory(long id) {
		Category category = getCategoryById(id);

		if (category != null) {
			em.remove(category);
		}
	}
	
	@Transactional
	public Category updateCategory(long id, Category newCategory){
		Category category = getCategoryById(id);
		
		category.setName(newCategory.getName());

		em.merge(category);
		return category;
	}
}
