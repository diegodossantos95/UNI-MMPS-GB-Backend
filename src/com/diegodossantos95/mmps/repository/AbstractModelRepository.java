package com.diegodossantos95.mmps.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.diegodossantos95.mmps.model.AbstractModel;

@NoRepositoryBean
public interface AbstractModelRepository<T extends AbstractModel> extends
		BaseRepository<T> {

		public List<T> findAll();
}