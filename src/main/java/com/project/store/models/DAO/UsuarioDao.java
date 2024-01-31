package com.project.store.models.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.store.entities.UsuarioEntity;

import jakarta.transaction.Transactional;

public interface UsuarioDao extends CrudRepository<UsuarioEntity, Long> {

    @Transactional
    @Query("SELECT us FROM UsuarioEntity us WHERE us.emailUsuario = ?1")
    public UsuarioEntity findByEmailUsuario(String emailUsuario);


}