package com.project.store.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.entities.ProductoVentaEntity;
import com.project.store.models.DAO.ProductoVentaDao;

import jakarta.transaction.Transactional;

@Service
public class ProductoVentaServiceImplement implements IProductoVentaService {

    @Autowired
    private ProductoVentaDao productoVentaDao;

    @Override
    @Transactional()
    public List<ProductoVentaEntity> findAll() {
        return (List<ProductoVentaEntity>) productoVentaDao.findAll();
    }

    @Override
    @Transactional
    public ProductoVentaEntity findById(Long id) {
        return productoVentaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(ProductoVentaEntity productoVenta) {
        productoVentaDao.save(productoVenta);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productoVentaDao.deleteById(id);
    }

    @Override
    @Transactional
    public ProductoVentaEntity actualizaProductoVentaEntity(ProductoVentaEntity productoVenta) {
        return productoVentaDao.save(productoVenta);
    }

}
