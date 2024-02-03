package com.project.store.models.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.store.entities.ProductoEntity;

import jakarta.transaction.Transactional;

public interface ProductoDao extends CrudRepository<ProductoEntity, Long> {

    @Transactional
    @Query("SELECT pr FROM ProductoEntity pr WHERE pr.nombreProducto LIKE %?1%")
    public List<ProductoEntity> findByNombreProducto(String producto);
}
