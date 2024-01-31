package com.project.store.models.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.entities.VentaEntity;
import com.project.store.models.DAO.VentaDao;

import jakarta.transaction.Transactional;

@Service
public class VentaServiceImplement implements IVentaService {
    

    @Autowired
    private VentaDao ventaDao;

    @Override
    @Transactional()
    public List<VentaEntity> findAll() {
        return (List<VentaEntity>) ventaDao.findAll();
    }

    @Override
    @Transactional
    public VentaEntity findById(Long id) {
        return ventaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(VentaEntity venta) {
        ventaDao.save(venta);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        ventaDao.deleteById(id);
    }

    @Override
    @Transactional
    public VentaEntity actualizaVentaEntity(VentaEntity venta) {
        return ventaDao.save(venta);
    }

}

