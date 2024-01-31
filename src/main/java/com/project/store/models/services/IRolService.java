package com.project.store.models.services;

import java.util.List;

import com.project.store.entities.RolEntity;

public interface IRolService {

    
    public List<RolEntity> findAll();

    public RolEntity findById(Long id);

    public void save(RolEntity rol);

    public void deleteById(Long id);

    public RolEntity actualizaRolEntity(RolEntity rol);
    
}

