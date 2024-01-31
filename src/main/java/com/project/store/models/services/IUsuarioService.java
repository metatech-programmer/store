package com.project.store.models.services;

import java.util.List;

import com.project.store.entities.UsuarioEntity;

public interface IUsuarioService {

    public List<UsuarioEntity> findAll();

    public UsuarioEntity findById(Long id);

    public void save(UsuarioEntity usuario);

    public void deleteById(Long id);

    public UsuarioEntity actualizaUsuarioEntity(UsuarioEntity usuario);

    public UsuarioEntity findByEmail(String email);


}
