package com.project.store.models.services;

import java.util.List;

import com.project.store.entities.ProductoVentaEntity;

public interface IProductoVentaService {
        
    public List<ProductoVentaEntity> findAll();

    public ProductoVentaEntity findById(Long id);

    public void save(ProductoVentaEntity productoVenta);

    public void deleteById(Long id);

    public ProductoVentaEntity actualizaProductoVentaEntity(ProductoVentaEntity productoVenta);
    
}