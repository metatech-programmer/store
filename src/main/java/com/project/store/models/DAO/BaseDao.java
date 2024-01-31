package com.project.store.models.DAO;

import org.springframework.data.repository.CrudRepository;

import com.project.store.entities.BaseEntity;

public interface BaseDao extends CrudRepository<BaseEntity, Long>{
    
}
