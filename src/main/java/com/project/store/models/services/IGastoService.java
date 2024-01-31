package com.project.store.models.services;

import java.util.List;

import com.project.store.entities.GastoEntity;

public interface IGastoService {
    
   public List<GastoEntity> findAll();

    public GastoEntity findById(Long id);

    public void save(GastoEntity gasto);

    public void deleteById(Long id);

    public GastoEntity actualizaGastoEntity(GastoEntity gasto);

}