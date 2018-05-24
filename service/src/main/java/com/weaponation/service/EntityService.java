package com.weaponation.service;

import com.weaponation.domain.BaseEntity;
import com.weaponation.repository.EntityRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Wallison Freitas
 */
public abstract class EntityService<T extends BaseEntity> {

    protected EntityRepository<T> repository;

    public EntityService(EntityRepository<T> repository) {
        this.repository = repository;
    }

    public abstract T save(T entity);

    public abstract boolean delete(Long id);

    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }
}
