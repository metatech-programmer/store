package com.project.store.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.entities.RolEntity;
import com.project.store.models.DAO.RolDao;


@Service
public class RolServiceImplement implements IRolService {

    @Autowired
    private RolDao rolDao;

    @Override
    public List<RolEntity> findAll() {
        return (List<RolEntity>) rolDao.findAll();
    }

    @Override
    public RolEntity findById(Long id) {
        return rolDao.findById(id).orElse(null);
    }

    @Override
    public void save(RolEntity rol) {
        rolDao.save(rol);
    }

    @Override
    public void deleteById(Long id) {
        rolDao.deleteById(id);

    }

    @Override
    public RolEntity actualizaRolEntity(RolEntity rol) {
        return rolDao.save(rol);
    }

}
