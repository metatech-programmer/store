package com.project.store.models.services;

import java.util.List;

import com.project.store.entities.VentaEntity;

public interface IVentaService {
    
   public List<VentaEntity> findAll();

    public VentaEntity findById(Long id);

    public void save(VentaEntity Venta);

    public void deleteById(Long id);

    public VentaEntity actualizaVentaEntity(VentaEntity Venta);

}
