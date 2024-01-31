package com.project.store.models.services;

import java.util.List;

import com.project.store.entities.ProductoEntity;

public interface IProductoService {
    
   public List<ProductoEntity> findAll();

    public ProductoEntity findById(Long id);

    public void save(ProductoEntity producto);

    public void deleteById(Long id);

    public ProductoEntity actualizaProductoEntity(ProductoEntity producto);

}