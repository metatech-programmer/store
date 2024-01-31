package com.project.store.models.services;

import java.util.List;

import com.project.store.entities.BaseEntity;

public interface IBaseService {
    
   public List<BaseEntity> findAll();

    public BaseEntity findById(Long id);

    public void save(BaseEntity base);

    public void deleteById(Long id);

    public BaseEntity actualizaBaseEntity(BaseEntity base);

}