package com.weaponation.service;

import com.weaponation.domain.BaseEntity;
import com.weaponation.exception.DuplicateEntityException;
import com.weaponation.exception.EntityNotFoundException;
import com.weaponation.repository.EntityRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Wallison Freitas
 */
public abstract class EntityService<T extends BaseEntity> {

    protected EntityRepository<T> repository;

    public EntityService(EntityRepository<T> repository) {
        this.repository = repository;
    }

    public T save(T entity) {
        Objects.requireNonNull(entity, "Entity cannot be null!");

        try {
            return repository.save(entity);
        } catch (DataIntegrityViolationException dataIntegrityException) {
            throw new DuplicateEntityException("Cannot save the '" + entity.getClass().getName() +
                    "' because it already exists!", dataIntegrityException);
        }
    }

    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw new EntityNotFoundException("Cannot delete entity with id '" + id +
                    "' because it does not exists!", emptyResultDataAccessException);
        }

        return !repository.existsById(id);
    }

    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }
}
