package com.project.store.models.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.entities.GastoEntity;
import com.project.store.models.DAO.GastoDao;

import jakarta.transaction.Transactional;

@Service
public class GastoServiceImplement implements IGastoService {

    @Autowired
    private GastoDao gastoDao;

    @Override
    @Transactional()
    public List<GastoEntity> findAll() {
        return (List<GastoEntity>) gastoDao.findAll();
    }

    @Override
    @Transactional
    public GastoEntity findById(Long id) {
        return gastoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(GastoEntity gasto) {
        gastoDao.save(gasto);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        gastoDao.deleteById(id);
    }

    @Override
    @Transactional
    public GastoEntity actualizaGastoEntity(GastoEntity gasto) {
        return gastoDao.save(gasto);
    }

}

