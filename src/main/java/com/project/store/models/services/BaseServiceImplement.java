package com.project.store.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.entities.BaseEntity;
import com.project.store.models.DAO.BaseDao;

import jakarta.transaction.Transactional;

@Service
public class BaseServiceImplement implements IBaseService {

    @Autowired
    private BaseDao baseDao;

    @Override
    @Transactional()
    public List<BaseEntity> findAll() {
        return (List<BaseEntity>) baseDao.findAll();
    }

    @Override
    @Transactional
    public BaseEntity findById(Long id) {
        return baseDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(BaseEntity base) {
        baseDao.save(base);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        baseDao.deleteById(id);
    }

    @Override
    @Transactional
    public BaseEntity actualizaBaseEntity(BaseEntity base) {
        return baseDao.save(base);
    }

}
