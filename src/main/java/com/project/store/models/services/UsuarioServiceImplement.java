package com.project.store.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.entities.UsuarioEntity;
import com.project.store.models.DAO.UsuarioDao;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional()
    public List<UsuarioEntity> findAll() {
        return (List<UsuarioEntity>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public UsuarioEntity findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(UsuarioEntity usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        usuarioDao.deleteById(id);
    }

    @Override
    @Transactional
    public UsuarioEntity actualizaUsuarioEntity(UsuarioEntity usuario) {
        return usuarioDao.save(usuario);
    }


    @Override
    public UsuarioEntity findByEmail(String email) {
    return usuarioDao.findByEmailUsuario(email);
    }    

}
