package com.project.store.models.DAO;

import org.springframework.data.repository.CrudRepository;

import com.project.store.entities.ProductoVentaEntity;


public interface  ProductoVentaDao extends CrudRepository<ProductoVentaEntity, Long> {

    
}
