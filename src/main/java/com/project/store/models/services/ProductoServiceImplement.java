package com.project.store.models.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.entities.ProductoEntity;
import com.project.store.models.DAO.ProductoDao;

import jakarta.transaction.Transactional;

@Service
public class ProductoServiceImplement implements IProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional()
    public List<ProductoEntity> findAll() {
        return (List<ProductoEntity>) productoDao.findAll();
    }

    @Override
    @Transactional
    public ProductoEntity findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(ProductoEntity producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productoDao.deleteById(id);
    }

    @Override
    @Transactional
    public ProductoEntity actualizaProductoEntity(ProductoEntity producto) {
        return productoDao.save(producto);
    }

    @Override
    @Transactional
    public List<ProductoEntity> findByNombreProducto(String nombre) {
        return (List<ProductoEntity>) productoDao.findByNombreProducto(nombre);
    }

}
