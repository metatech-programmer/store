package com.project.store.models.DAO;

import org.springframework.data.repository.CrudRepository;

import com.project.store.entities.ProductoEntity;

public interface ProductoDao extends CrudRepository<ProductoEntity, Long> {
    
}
