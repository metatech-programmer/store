package com.project.store.models.DAO;

import org.springframework.data.repository.CrudRepository;

import com.project.store.entities.GastoEntity;

public interface GastoDao extends CrudRepository<GastoEntity, Long> {
    
}
