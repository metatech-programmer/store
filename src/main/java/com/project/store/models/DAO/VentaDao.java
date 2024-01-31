package com.project.store.models.DAO;

import org.springframework.data.repository.CrudRepository;

import com.project.store.entities.VentaEntity;

public interface VentaDao extends CrudRepository<VentaEntity, Long> {
    
}
